package projeto.edu.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projeto.edu.api.turma.*;

import java.util.List;

@RestController
@RequestMapping("turma")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTurma dados, UriComponentsBuilder uriBuilder){
        var turma = new Turma(dados);
        repository.save(turma);

        var uri =  uriBuilder.path("/turma/{id}").buildAndExpand(turma.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTurma(turma));
    }

    @GetMapping
    public ResponseEntity<Page<Turma>> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao);
        return ResponseEntity.ok(page);
    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarTurma dados){
        var turma = repository.getReferenceById(dados.id());
        turma.atualizarInfomacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoTurma(turma));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var turma = repository.getReferenceById(id);
        turma.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var turma = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoTurma(turma));
    }
}
