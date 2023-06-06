package projeto.edu.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import projeto.edu.api.turma.*;

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
    public Page<Turma> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao);
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarTurma dados){
        var turma = repository.getReferenceById(dados.id());
        turma.atualizarInfomacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var turma = repository.getReferenceById(id);
        turma.excluir();
        return ResponseEntity.noContent().build();
    }
}
