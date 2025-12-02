package com.example.proyectos_rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dev_id")
    private Long id;

    @Column(name = "devname", length = 20)
    private String name;

    @Column(name = "dev_surname", length = 60)
    private String surname;

    @Column(name = "email", length = 90)
    private String email;

    @Column(name = "linkedin_url", length = 90)
    private String linkedinUrl;

    @Column(name = "github_url", length = 90)
    private String githubUrl;

    @JsonIgnore
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects;
}
