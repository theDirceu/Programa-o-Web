package com.example.matricula.model;

import lombok.Data;

@Entity
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String matricula;

    @Column(unique = true)
    private String email;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
}
