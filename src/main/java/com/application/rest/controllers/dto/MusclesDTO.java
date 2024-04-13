package com.application.rest.controllers.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MusclesDTO {

    private Long id;

    private String name;

    private List<String> exercises;

}
