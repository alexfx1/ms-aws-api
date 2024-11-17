package com.business.aws.studs.service;

import com.business.aws.studs.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HealthCheckService implements HealthIndicator {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Health health() {
        try {
            if (userRepository.count() >= 0) {
                return Health.up().withDetail("database", "Available").build();
            }
        } catch (Exception e) {
            log.error("Err in health method: " + e.getMessage());
            return Health.down().withDetail("database", "Not Available").withException(e).build();
        }
        return Health.unknown().build();
    }

}
