package com.example.proyectos_rest.service;

import com.example.proyectos_rest.entity.Technology;
import com.example.proyectos_rest.repository.TechnologyRepository;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public Technology save(Technology technology) {
        return technologyRepository.save(technology);
    }

    public void delete(Long id) {
        if (!technologyRepository.existsById(id)) {
            throw new RuntimeException("Tecnología no encontrada");
        }
        technologyRepository.deleteById(id);
    }
}
