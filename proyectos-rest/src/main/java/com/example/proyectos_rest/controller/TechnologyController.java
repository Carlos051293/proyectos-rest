package com.example.proyectos_rest.controller;

import com.example.proyectos_rest.entity.Technology;
import com.example.proyectos_rest.service.TechnologyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology) {
        Technology newTech = technologyService.save(technology);
        return ResponseEntity.ok(newTech);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTechnology(@PathVariable Long id) {
        technologyService.delete(id);
        return ResponseEntity.ok("Tecnología eliminada correctamente");
    }
}
