package com.example.proyectos_rest.repository;

import com.example.proyectos_rest.entity.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}
