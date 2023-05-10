package com.example.matricula.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;

@EntityScan
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sala;

    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    @ManyToMany(mappedBy = "turmas")
    private List<Professor> professores;
}
