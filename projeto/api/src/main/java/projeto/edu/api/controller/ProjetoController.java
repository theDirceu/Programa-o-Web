package projeto.edu.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.projeto.*;


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
    public Page<Projeto> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarProjeto dados){
        var projeto = repository.getReferenceById(dados.id());
        projeto.atualizarInfomacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var projeto = repository.getReferenceById(id);
        projeto.excluir();
        return ResponseEntity.noContent().build();
    }
}
