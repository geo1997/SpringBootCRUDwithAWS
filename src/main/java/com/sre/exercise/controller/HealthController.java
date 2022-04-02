package com.sre.exercise.controller;

import com.sre.exercise.entity.HealthDTO;
import com.sre.exercise.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {


    private HealthService healthService;

    @Autowired
    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    @GetMapping("/health")
    public ResponseEntity<HealthDTO> getHealth() {
        HealthDTO healthDTO = healthService.getHealth();
        healthDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HealthController.class).getHealth()).withSelfRel());
        return new ResponseEntity<>(healthDTO, HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<HealthDTO> getVersion() {
        HealthDTO healthDTO = healthService.getHealth();
        healthDTO.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(HealthController.class).getVersion()).withSelfRel());
        return new ResponseEntity<>(healthDTO, HttpStatus.OK);
    }

}
