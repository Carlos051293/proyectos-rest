package com.example.proyectos_rest.service;

import com.example.proyectos_rest.entity.Project;
import com.example.proyectos_rest.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<Project> findByWord(String word) {
        return projectRepository.findByNameContainingIgnoreCase(word);
    }

    public Project save(Project project) {
        return projectRepository.save(project);
    }

    public Project update(Long id, Project projectData) {
        Project existing = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));

        existing.setName(projectData.getName());
        existing.setDescription(projectData.getDescription());
        existing.setStartDate(projectData.getStartDate());
        existing.setEndDate(projectData.getEndDate());
        existing.setDemoUrl(projectData.getDemoUrl());
        existing.setPicture(projectData.getPicture());
        existing.setStatus(projectData.getStatus());
        existing.setTechnologies(projectData.getTechnologies());
        existing.setDevelopers(projectData.getDevelopers());

        return projectRepository.save(existing);
    }

    // 👉 DELETE /projects/{id}
    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Proyecto no encontrado");
        }
        projectRepository.deleteById(id);
    }
}
