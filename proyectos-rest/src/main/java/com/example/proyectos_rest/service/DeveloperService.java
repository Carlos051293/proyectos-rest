package com.example.proyectos_rest.service;

import com.example.proyectos_rest.entity.Developer;
import com.example.proyectos_rest.repository.DeveloperRepository;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public void delete(Long id) {
        if (!developerRepository.existsById(id)) {
            throw new RuntimeException("Developer no encontrado");
        }
        developerRepository.deleteById(id);
    }
}
