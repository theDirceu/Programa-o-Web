package com.example.matricula.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorRepository professorRepository;
    private final TurmaRepository turmaRepository;

    @Autowired
    public ProfessorController(ProfessorRepository professorRepository, TurmaRepository turmaRepository) {
        this.professorRepository = professorRepository;
        this.turmaRepository = turmaRepository;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessores() {
        List<Professor> professores = professorRepository.findAll();
        return ResponseEntity.ok(professores);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Professor professor = professorRepository.findById(id).orElse(null);
        if (professor != null) {
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professor.setId(id);
        Professor professorAtualizado = professorRepository.save(professor);
        return ResponseEntity.ok(professorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        if (!professorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/turmas/{turmaId}/matriculas/{professorId}")
    public ResponseEntity<Professor> vincularProfessorTurma(@PathVariable Long turmaId, @PathVariable Long professorId) {
        Turma turma = turmaRepository.findById(turmaId).orElse(null);
        Professor professor = professorRepository.findById(professorId).orElse(null);
        if (turma != null && professor != null) {
            professor.getTurmas().add(turma);
            professorRepository.save(professor);
            return ResponseEntity.ok(professor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
