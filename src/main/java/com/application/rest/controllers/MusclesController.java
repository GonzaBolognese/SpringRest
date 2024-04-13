package com.application.rest.controllers;

import com.application.rest.controllers.dto.MusclesDTO;
import com.application.rest.model.Exercises;
import com.application.rest.model.Muscles;
import com.application.rest.service.implement.MusclesServicesImp;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/muscles")
public class MusclesController {

    @Autowired
    private MusclesServicesImp musclesServices;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Muscles> musclesOptional = musclesServices.findById(id);

        if(musclesOptional.isPresent()){
            Muscles muscles = musclesOptional.get();
            List<String> exercisesName = muscles.getExercises().stream()
                    .map(exercise -> exercise.getName()) // Aquí se extraen los nombres de los músculos
                    .toList();
            MusclesDTO musclesDTO = MusclesDTO.builder()
                    .id(muscles.getId())
                    .name(muscles.getName())
                    .exercises(exercisesName)
                    .build();
            return ResponseEntity.ok(musclesDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/find")
    public ResponseEntity<?> findAll(){
        List<MusclesDTO> musclesList = musclesServices.findAll()
                .stream()
                .map(muscle -> {
                    List<String> exercisesName = muscle.getExercises()
                            .stream()
                            .map(exercise -> exercise.getName())
                            .toList();

                    return MusclesDTO.builder()
                            .id(muscle.getId())
                            .name(muscle.getName())
                            .exercises(exercisesName)
                            .build();
                })
                .toList();
        return ResponseEntity.ok(musclesList);

    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody MusclesDTO musclesDTO) throws URISyntaxException {
        if(musclesDTO.getName().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        musclesServices.save(Muscles.builder()
                .name(musclesDTO.getName())
                .build());

        return ResponseEntity.created(new URI("/api/muscles/save")).body("Se ha agregado un nuevo musculo correctamente");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMuscle(@PathVariable Long id, @RequestBody MusclesDTO musclesDTO){
        Optional<Muscles> musclesOptional = musclesServices.findById(id);

        if(musclesOptional.isPresent()){
            Muscles muscle = musclesOptional.get();
            muscle.setName(musclesDTO.getName());
            musclesServices.save(muscle);
            return ResponseEntity.ok("Se ha modificado con exito");
        }

        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMuscle(@PathVariable Long id){
        if(id != null){
            musclesServices.deleteById(id);
            return ResponseEntity.ok("Musculo eliminado");
        }

        return ResponseEntity.badRequest().build();
    }

}
