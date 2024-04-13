package com.application.rest.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "muscles")
public class Muscles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "muscles")
    private List<Exercises> exercises;
}
