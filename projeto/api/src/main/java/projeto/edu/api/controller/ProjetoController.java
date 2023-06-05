package projeto.edu.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.projeto.DadosCadastroProjeto;
import projeto.edu.api.projeto.Projeto;
import projeto.edu.api.projeto.ProjetoRepository;

import java.util.List;

@RestController
@RequestMapping("projeto")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroProjeto dados){
        repository.save(new Projeto(dados));
    }

    @GetMapping
    public Page<Projeto> lista(Pageable paginacao){
        return repository.findAll(paginacao);
    }
}
