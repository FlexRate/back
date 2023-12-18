package com.sbb.flexrate.controller;

import com.sbb.flexrate.dto.DashboardResponseDto;
import com.sbb.flexrate.service.DashboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/main")//aws 임시 main
@Api
public class MainController {

    private final DashboardService dashboardService;
    @GetMapping("/dashboard/{memberId}")
    public ResponseEntity<DashboardResponseDto> handleMainRequest(@PathVariable Long memberId) {

        DashboardResponseDto dto = dashboardService.getInfo(memberId);

        return ResponseEntity.ok(dto);

    }
}
