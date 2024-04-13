package com.application.rest.DAO;

import com.application.rest.model.Muscles;

import java.util.List;
import java.util.Optional;

public interface MusclesDAO {
    List<Muscles> findAll();

    Optional<Muscles> findById(Long id);
    void save (Muscles muscles);

    void deleteById(Long id);
}
