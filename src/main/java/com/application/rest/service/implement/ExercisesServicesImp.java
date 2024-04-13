package com.application.rest.service.implement;

import com.application.rest.DAO.ExercisesDAO;
import com.application.rest.DAO.implement.ExercisesDAOImp;
import com.application.rest.model.Exercises;
import com.application.rest.service.ExercisesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ExercisesServicesImp implements ExercisesService {

    @Autowired
    private ExercisesDAOImp exercisesDAO;
    @Override
    public List<Exercises> findAll() {
        return exercisesDAO.findAll();
    }

    @Override
    public Optional<Exercises> findById(UUID id) {
        return exercisesDAO.findById(id);
    }

    /*@Override
    public List<Exercises> findByMuscle(String string) {
        return exercisesDAO.findByMuscle(string);
    }*/

    @Override
    public void save(Exercises exercises) {
        exercisesDAO.save(exercises);
    }

    @Override
    public void deleteById(UUID id) {
        exercisesDAO.deleteById(id);
    }
}
