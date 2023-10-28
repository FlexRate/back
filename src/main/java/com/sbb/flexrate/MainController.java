package com.sbb.flexrate;

import com.sbb.flexrate.dashboard.DashboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {
    private final DashboardRepository dashboardRepository;
}
