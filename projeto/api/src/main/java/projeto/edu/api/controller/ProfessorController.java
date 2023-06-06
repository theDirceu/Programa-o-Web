package projeto.edu.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.professor.*;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody DadosCadastroProfessor dados){
        repository.save(new Professor(dados));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemProfessor>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfessor::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarProfessor dados){
        var professor = repository.getReferenceById(dados.id());
        professor.atualizarInfomacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProfessor(professor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var professor = repository.getReferenceById(id);
        professor.excluir();
        return ResponseEntity.noContent().build();
    }
}
