package com.application.rest.DAO.implement;

import com.application.rest.DAO.ExercisesDAO;
import com.application.rest.model.Exercises;
import com.application.rest.repository.ExercisesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ExercisesDAOImp implements ExercisesDAO {

    @Autowired
    private ExercisesRepository exercisesRepository;

    @Override
    public List<Exercises> findAll() {
        return (List<Exercises>) exercisesRepository.findAll();
    }

    @Override
    public Optional<Exercises> findById(UUID id) {
        return exercisesRepository.findById(id);
    }

    /*@Override
    public List<Exercises> findByMuscle(String string) {
        return exercisesRepository.findExercisesByMuscles(string);
    }*/

    @Override
    public void save(Exercises exercises) {

        exercisesRepository.save(exercises);
    }

    @Override
    public void deleteById(UUID id) {
        exercisesRepository.deleteById(id);
    }
}
