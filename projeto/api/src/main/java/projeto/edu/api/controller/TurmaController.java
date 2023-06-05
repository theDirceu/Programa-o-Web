package projeto.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.projeto.Projeto;
import projeto.edu.api.turma.DadosCadastroTurma;
import projeto.edu.api.turma.Turma;
import projeto.edu.api.turma.TurmaRepository;

import java.util.List;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroTurma dados){
        repository.save(new Turma(dados));
    }

    @GetMapping
    public Page<Turma> lista(Pageable paginacao){
        return repository.findAll(paginacao);
    }
}
