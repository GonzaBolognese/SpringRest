package com.application.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "exercises")
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private String image;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String instructions;

    private String equipment;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "exercise_muscle", joinColumns = @JoinColumn(name = "exercise_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "muscle_id", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Muscles> muscles;
}
