package com.example.proyectos_rest.controller;

import com.example.proyectos_rest.entity.Project;
import com.example.proyectos_rest.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAll() {
        List<Project> list = projectService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{word}")
    public ResponseEntity<List<Project>> getByWord(@PathVariable String word) {
        List<Project> list = projectService.findByWord(word);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project newProject = projectService.save(project);
        return ResponseEntity.ok(newProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
        Project updated = projectService.update(id, project);
        return ResponseEntity.ok(updated);
    }

    // 👉 DELETE /projects/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.ok("Proyecto eliminado correctamente");
    }
}
