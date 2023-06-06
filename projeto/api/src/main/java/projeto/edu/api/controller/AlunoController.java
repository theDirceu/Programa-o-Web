package projeto.edu.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.aluno.*;

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
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInfomacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();
        return ResponseEntity.noContent().build();
    }
}
