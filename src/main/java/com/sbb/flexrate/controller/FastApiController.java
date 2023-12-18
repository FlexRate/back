package com.sbb.flexrate.controller;


import com.sbb.flexrate.dto.LoanApplicationDTO;
import io.swagger.annotations.Api;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/fastapi")
@Api
public class FastApiController {

    @PostMapping("/request-to-fastapi")
    public ResponseEntity<String> requestToFastApi(@RequestBody LoanApplicationDTO requestData) {
        RestTemplate restTemplate = new RestTemplate();
        String fastApiUrl = "http://localhost:8000/predict_loan_limit"; // FastAPI 엔드포인트 URL

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoanApplicationDTO> entity = new HttpEntity<>(requestData, headers);

        // FastAPI 엔드포인트 호출 및 응답 받기
        ResponseEntity<String> response = restTemplate.postForEntity(fastApiUrl, entity, String.class);

        // 결과 반환
        return response;
    }
}
