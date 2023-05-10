package com.example.matricula.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    @Autowired
    public AlunoController(AlunoRepository alunoRepository, TurmaRepository turmaRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return ResponseEntity.ok(alunos);
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoRepository.save(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);
        if (aluno != null) {
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aluno.setId(id);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/turmas/{turmaId}/matriculas/{alunoId}")
    public ResponseEntity<Aluno> vincularAlunoTurma(@PathVariable Long turmaId, @PathVariable Long alunoId) {
        Turma turma = turmaRepository.findById(turmaId).orElse(null);
        Aluno aluno = alunoRepository.findById(alunoId).orElse(null);
        if (turma != null && aluno != null) {
            aluno.setTurma(turma);
            alunoRepository.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
