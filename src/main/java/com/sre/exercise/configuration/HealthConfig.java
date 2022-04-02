package com.sre.exercise.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class HealthConfig {

    @Value("${info.app.name}")
    private String name;

    @Value("${info.app.version}")
    private String version;



}
