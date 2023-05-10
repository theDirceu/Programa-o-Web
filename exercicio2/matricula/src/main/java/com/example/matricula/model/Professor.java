package com.example.matricula.model;

import lombok.Data;

import java.util.List;

@Entity
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String email;

    private String nome;
    private String formacao;

    @ManyToMany
    @JoinTable(name = "professor_turma",
    joinColumns = @JoinColumn(name = "professor_id"),
    inverseJoinColumns = @JoinColumn(name = "turma_id"))
private List<Turma> turmas;
}