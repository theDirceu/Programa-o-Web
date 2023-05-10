package controle_matriculas.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

import controle_matriculas.domain.Turma;
import controle_matriculas.dto.TurmaDTO;
import controle_matriculas.repository.TurmaRepository;
import controle_matriculas.mapper.TurmaMapper;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private TurmaMapper turmaMapper;

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todas as Turmas")
    public List<TurmaDTO> getTurmas(){
        List<Turma> turmas = turmaRepository.findAll();
        return turmas.stream()
                        .map(turmaMapper::convertToTurmaDTO)
                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma turma pelo seu Identificador")
    public Optional<Turma> getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria uma nova Turma")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma Turma a partir do seu identificador")
    public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma Turma a partir do seu identificador")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    } 
    
}
