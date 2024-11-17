package com.business.aws.studs.controller;

import com.business.aws.studs.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/healthCheck")
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/checkApi")
    public Health checkApi() {
        return healthCheckService.health();
    }

}
