package com.application.rest.DAO;

import com.application.rest.model.Exercises;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExercisesDAO {

    List<Exercises> findAll();
    Optional<Exercises> findById(UUID id);

    /*List<Exercises> findByMuscle(String string);*/

    void save(Exercises exercises);

    void deleteById(UUID id);

}
