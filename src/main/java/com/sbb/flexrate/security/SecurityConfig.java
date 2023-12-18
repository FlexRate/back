package com.sbb.flexrate.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.security.authentication.BadCredentialsException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    private final JwtProvider jwtProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // ID, Password 문자열을 Base64로 인코딩하여 전달하는 구조
                .httpBasic().disable()
                // 쿠키 기반이 아닌 JWT 기반이므로 사용하지 않음
                .csrf().disable()
                // Spring Security 세션 정책 : 세션을 생성 및 사용하지 않음
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 조건별로 요청 허용/제한 설정
                .authorizeRequests()
                // 회원가입과 로그인은 모두 승인
                .antMatchers("/login", "/register", "/main/**").permitAll()
                //admin으로 시작하는 요청은 ADMIN 권한이 있는 유저에게만 허용
                .antMatchers("/admin").hasRole("ADMIN")
                // /user 로 시작하는 요청은 USER 권한이 있는 유저에게만 허용
                .antMatchers("/**").hasRole("USER")
                .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-resources/**","/swagger-ui/springfox.js").permitAll()
                .anyRequest().denyAll() //이래도 되나
                .and()
                //cors 설정
                .cors(c -> {
                            CorsConfigurationSource source = request -> {
                                // Cors 허용 패턴
                                CorsConfiguration config = new CorsConfiguration();
                                config.setAllowedOrigins(
                                        List.of("http://localhost:5173", "http://localhost:8080")
                                );
                                config.setAllowedMethods(
                                        List.of("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS")
                                );
                                config.setAllowedHeaders(
                                        List.of("*")
                                );
//                                config.setExposedHeaders(
//                                        List.of("Authorization")
//                                );
                                config.setAllowCredentials(true);
                                return config;
                            };
                            c.configurationSource(source);
                        }
                );
        http
                // JWT 인증 필터 적용, 인증 처리 기본필터 username~
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                // 에러 핸들링
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
                        //권한 문제가 발생 시 이부분 호출
                        response.setStatus(403);
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html;charset=UTF-8");
                        response.getWriter().write("권한이 없는 사용자입니다.");
                    }
                })
                .authenticationEntryPoint(new AuthenticationEntryPoint() {
                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        response.setStatus(401);
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("text/html;charset=UTF-8");

                        if (authException instanceof BadCredentialsException) {
                            if (authException.getCause() instanceof UsernameNotFoundException) {
                                response.getWriter().write("잘못된 아이디입니다.");
                            } else {
                                response.getWriter().write("잘못된 비밀번호입니다.");
                            }
                        } else {
                            response.getWriter().write("인증되지 않은 사용자입니다.");
                        }
                    }
                });

        return http.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(
                /* swagger v2 */
                "/v2/api-docs",
                "/swagger-resources",
                "/swagger-resources/**",
                "/configuration/ui",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**",
                /* swagger v3 */
                "/v3/api-docs/**",
                "/swagger-ui/**");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
        //{noop}asd34d*^ 과 같이 password 앞에 encoding 방식 붙은 채로 저장-> 엄호화 방식 지정 저장 가능
    }


}