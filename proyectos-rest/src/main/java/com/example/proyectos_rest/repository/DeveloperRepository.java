package com.example.proyectos_rest.repository;

import com.example.proyectos_rest.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
