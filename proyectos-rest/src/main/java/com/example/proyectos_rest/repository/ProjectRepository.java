package com.example.proyectos_rest.repository;

import com.example.proyectos_rest.entity.Project;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @EntityGraph(attributePaths = {"status", "technologies", "developers"})
    List<Project> findAll();

    @EntityGraph(attributePaths = {"status", "technologies", "developers"})
    List<Project> findByNameContainingIgnoreCase(String word);
}
