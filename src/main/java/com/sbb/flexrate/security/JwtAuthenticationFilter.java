package com.sbb.flexrate.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Jwt가 유효성을 검증하는 Filter
 */
/*
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProvider.resolveToken(request);

            if (token != null && jwtProvider.validateToken(token)) {
                // check access token
                token = token.split(" ")[1].trim();
                Authentication auth = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            filterChain.doFilter(request, response);
        } catch (AuthenticationException e) {
            // 여기서 AuthenticationException을 처리
            logger.error( e.getMessage(), e); // 디버그 로그 추가
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/plain;charset=UTF-8");

            if (e instanceof BadCredentialsException) {
                response.getWriter().write("아이디 또는 비밀번호가 잘못됐습니다.");
            } else {
                response.getWriter().write("인증되지 않은 사용자입니다.");
            }

            return;
        }
    }
}
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = jwtProvider.resolveToken(request);
//
//        if (token != null && jwtProvider.validateToken(token)) {
//            // check access token
//            token = token.split(" ")[1].trim();
//            Authentication auth = jwtProvider.getAuthentication(token);
//            SecurityContextHolder.getContext().setAuthentication(auth);
//        }
//
//        filterChain.doFilter(request, response);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String token = jwtProvider.resolveToken(request);

            if (token != null && jwtProvider.validateToken(token)) {
                // check access token
                token = token.split(" ")[1].trim();
                Authentication auth = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

            filterChain.doFilter(request, response);
        } catch (AuthenticationException e) {
            // 여기서 AuthenticationException을 처리
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/plain;charset=UTF-8");

//            if (e instanceof BadCredentialsException) {
//                response.getWriter().write("아이디 또는 비밀번호가 잘못됐습니다.");
//            } else {
//                response.getWriter().write("인증되지 않은 사용자입니다.");
//            }

            return;
        }
    }
}