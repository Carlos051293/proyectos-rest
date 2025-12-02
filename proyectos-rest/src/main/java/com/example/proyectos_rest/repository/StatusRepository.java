package com.example.proyectos_rest.repository;

import com.example.proyectos_rest.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
