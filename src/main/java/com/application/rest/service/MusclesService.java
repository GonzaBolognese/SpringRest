package com.application.rest.service;

import com.application.rest.model.Muscles;

import java.util.List;
import java.util.Optional;

public interface MusclesService {
    List<Muscles> findAll();

    Optional<Muscles> findById(Long id);
    void save (Muscles muscles);

    void deleteById(Long id);
}
