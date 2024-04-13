package com.application.rest.controllers.dto;

import com.application.rest.model.Muscles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

//Data Transfer Object
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExercisesDTO {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private String instructions;
    private String equipment;
    private List<String> muscles;
}
