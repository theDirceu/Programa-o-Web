package projeto.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.aluno.DadosCadastroAluno;
import projeto.edu.api.aluno.Aluno;
import projeto.edu.api.aluno.AlunoRepository;
import projeto.edu.api.aluno.DadosListagemAluno;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DadosListagemAluno> listar(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemAluno::new);
    }
}
