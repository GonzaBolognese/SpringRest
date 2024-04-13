package com.application.rest.repository;

import com.application.rest.model.Exercises;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExercisesRepository extends CrudRepository<Exercises, UUID> {
/*
   @Query("SELECT e FROM Exercises e JOIN exercise_muscle em ON e.id = em.exercise_id JOIN Muscles m ON em.muscle_id = m.id WHERE m.name = 'pectoral'")
    List<Exercises> findExercisesByMuscles(String string);

 */

}
