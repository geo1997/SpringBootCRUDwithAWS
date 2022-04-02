package com.sre.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HealthDTO extends RepresentationModel<HealthDTO> {

    private String name;
    private String version;
    private String status;


}
