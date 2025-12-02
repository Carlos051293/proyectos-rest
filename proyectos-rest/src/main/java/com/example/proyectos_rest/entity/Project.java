package com.example.proyectos_rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "demo_url", length = 150)
    private String demoUrl;

    @Column(name = "picture", length = 150)
    private String picture;

    @ManyToOne
    @JoinColumn(name = "status_status_id", referencedColumnName = "status_id")
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "technologies_used_in_projects",
            joinColumns = @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "tecnologia_tecnologia_id", referencedColumnName = "tech_id")
    )
    private Set<Technology> technologies;

    @ManyToMany
    @JoinTable(
            name = "developers_worked_on_projects",
            joinColumns = @JoinColumn(name = "projects_project_id", referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_dev_id", referencedColumnName = "dev_id")
    )
    private Set<Developer> developers;
}
