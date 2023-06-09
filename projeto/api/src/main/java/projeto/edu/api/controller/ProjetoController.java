package projeto.edu.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import projeto.edu.api.domain.projeto.*;

@RestController
@RequestMapping("projeto")
@SecurityRequirement(name = "bearer-key")
public class ProjetoController {

    @Autowired
    private ProjetoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroProjeto dados, UriComponentsBuilder uriBuilder){
        var projeto = new Projeto(dados);
        repository.save(projeto);

        var uri =  uriBuilder.path("/projeto/{id}").buildAndExpand(projeto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoProjeto(projeto));
    }

    @GetMapping
    public ResponseEntity<Page<Projeto>> lista(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarProjeto dados){
        var projeto = repository.getReferenceById(dados.id());
        projeto.atualizarInfomacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoProjeto(projeto));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var projeto = repository.getReferenceById(id);
        projeto.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var projeto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoProjeto(projeto));
    }
}
