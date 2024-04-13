package com.application.rest.DAO.implement;

import com.application.rest.DAO.MusclesDAO;
import com.application.rest.model.Muscles;
import com.application.rest.repository.MusclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MusclesDAOImp implements MusclesDAO {

    @Autowired
    private MusclesRepository musclesRepository;

    @Override
    public List<Muscles> findAll() {
        return (List<Muscles>) musclesRepository.findAll();
    }

    @Override
    public Optional<Muscles> findById(Long id) {
        return musclesRepository.findById(id);
    }

    @Override
    public void save(Muscles muscles) {
        musclesRepository.save(muscles);
    }

    @Override
    public void deleteById(Long id) {
        musclesRepository.deleteById(id);
    }
}
