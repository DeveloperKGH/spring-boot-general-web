package com.kgh.web.global.common.controller;

import com.kgh.web.global.common.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HealthCheckController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping(value="/health-check")
    public BaseResponse<String> checkHealth() {
        String result = "Welcome to " + appName + " API Server !!!!";
        return BaseResponse.successResponse(result);
    }

}