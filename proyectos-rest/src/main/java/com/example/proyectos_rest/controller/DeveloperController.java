package com.example.proyectos_rest.controller;

import com.example.proyectos_rest.entity.Developer;
import com.example.proyectos_rest.service.DeveloperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public ResponseEntity<Developer> createDeveloper(@RequestBody Developer developer) {
        Developer newDev = developerService.save(developer);
        return ResponseEntity.ok(newDev);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDeveloper(@PathVariable Long id) {
        developerService.delete(id);
        return ResponseEntity.ok("Developer eliminado correctamente");
    }
}
