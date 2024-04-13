package com.application.rest.controllers;

import com.application.rest.DAO.MusclesDAO;
import com.application.rest.controllers.dto.ExercisesDTO;
import com.application.rest.model.Exercises;
import com.application.rest.service.implement.ExercisesServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {

    @Autowired
    private ExercisesServicesImp exercisesServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable UUID id) {
        Optional<Exercises> exercisesOptional = exercisesServices.findById(id);


        if(exercisesOptional.isPresent()){
            Exercises exercise = exercisesOptional.get();

            List<String> muscleNames = exercise.getMuscles().stream()
                    .map(muscle -> muscle.getName()) // Aquí se extraen los nombres de los músculos
                    .toList();

            ExercisesDTO exercisesDTO = ExercisesDTO.builder()
                    .id(exercise.getId())
                    .name(exercise.getName())
                    .description(exercise.getDescription())
                    .image(exercise.getImage())
                    .instructions(exercise.getInstructions())
                    .equipment(exercise.getEquipment())
                    .muscles(muscleNames)
                    .build();
            return ResponseEntity.ok(exercisesDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findAll() {
        List<ExercisesDTO> exercisesList = exercisesServices.findAll()
                .stream()
                .map(exercise -> {
                    List<String> muscleNames = exercise.getMuscles().stream()
                            .map(muscle -> muscle.getName()) // Aquí se extraen los nombres de los músculos
                            .toList();

                    return ExercisesDTO.builder()
                            .id(exercise.getId())
                            .name(exercise.getName())
                            .description(exercise.getDescription())
                            .image(exercise.getImage())
                            .instructions(exercise.getInstructions())
                            .equipment(exercise.getEquipment())
                            .muscles(muscleNames)
                            .build();
                })
                .toList();

        return ResponseEntity.ok(exercisesList);
        }

        @PostMapping("/save")
        public ResponseEntity<?> save(@RequestBody ExercisesDTO exercisesDTO) throws URISyntaxException {

            if(exercisesDTO.getName().isBlank() ||
                    exercisesDTO.getDescription().isBlank() ||
                    exercisesDTO.getImage().isBlank() ||
                    exercisesDTO.getInstructions().isBlank() ||
                    exercisesDTO.getEquipment().isBlank()) {
                return ResponseEntity.badRequest().build();
            }

            exercisesServices.save(Exercises.builder()
                    .id(UUID.randomUUID())
                    .name(exercisesDTO.getName())
                    .description(exercisesDTO.getDescription())
                    .image(exercisesDTO.getImage())
                    .instructions(exercisesDTO.getInstructions())
                    .equipment(exercisesDTO.getEquipment())
                    .build());

            return ResponseEntity.created(new URI("/api/exercises/save")).body("El ejercicio se ha guardado correctamente.");
        }

        @PutMapping("/update/{id}")
        public ResponseEntity<?> updateMaker(@PathVariable UUID id, @RequestBody ExercisesDTO exercisesDTO){
            Optional<Exercises> exercisesOptional = exercisesServices.findById(id);

            if(exercisesOptional.isPresent()){
                Exercises exercises = exercisesOptional.get();
                exercises.setName(exercisesDTO.getName());
                exercisesServices.save(exercises);
                return ResponseEntity.ok("Registro Actualizado");
            }

            return ResponseEntity.notFound().build();
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deleteById(@PathVariable UUID id){
            if(id != null){
                exercisesServices.deleteById(id);
                return ResponseEntity.ok("Ejercicio Eliminado");
            }

            return ResponseEntity.badRequest().build();
        }
    }
