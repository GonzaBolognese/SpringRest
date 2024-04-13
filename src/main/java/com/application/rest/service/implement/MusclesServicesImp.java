package com.application.rest.service.implement;

import com.application.rest.DAO.implement.MusclesDAOImp;
import com.application.rest.model.Muscles;
import com.application.rest.service.MusclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusclesServicesImp implements MusclesService {

    @Autowired
    private MusclesDAOImp musclesDAO;

    @Override
    public List<Muscles> findAll() {
        return musclesDAO.findAll();
    }

    @Override
    public Optional<Muscles> findById(Long id) {
        return musclesDAO.findById(id);
    }

    @Override
    public void save(Muscles muscles) {
        musclesDAO.save(muscles);
    }

    @Override
    public void deleteById(Long id) {
        musclesDAO.deleteById(id);
    }
}
