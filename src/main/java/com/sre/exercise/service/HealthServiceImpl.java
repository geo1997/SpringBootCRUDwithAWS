package com.sre.exercise.service;

import com.sre.exercise.configuration.HealthConfig;
import com.sre.exercise.entity.HealthDTO;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService{

    private final HealthConfig healthConfig;

    public HealthServiceImpl(HealthConfig healthConfig) {
        this.healthConfig = healthConfig;
    }

    @Override
    public HealthDTO getHealth() {
        return new HealthDTO(healthConfig.getName(),healthConfig.getVersion(),"UP");
    }


}
