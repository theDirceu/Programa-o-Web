package projeto.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.aluno.DadosListagemAluno;
import projeto.edu.api.professor.DadosCadastroProfessor;
import projeto.edu.api.professor.DadosListagemProfessor;
import projeto.edu.api.professor.Professor;
import projeto.edu.api.professor.ProfessorRepository;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroProfessor dados){
        repository.save(new Professor(dados));
    }

    @GetMapping
    public Page<DadosListagemProfessor> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProfessor::new);
    }
}
