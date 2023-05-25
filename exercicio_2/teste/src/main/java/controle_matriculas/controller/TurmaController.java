package controle_matriculas.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;

import controle_matriculas.domain.Turma;
import controle_matriculas.dto.GenericResponseErrorDTO;
import controle_matriculas.dto.TurmaDTO;
import controle_matriculas.services.TurmaService;
import controle_matriculas.mapper.TurmaMapper;
import controle_matriculas.exceptions.ExistingTurmaSameNameException;

@RestController
@RequestMapping(value = "/turmas", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
@Api(value = "Turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaMapper turmaMapper;

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todas as Turmas")
    public List<TurmaDTO> getTurmas(){
        List<Turma> turmas = turmaService.listAllTurmas();
        return turmas.stream()
                        .map(turmaMapper::convertToTurmaDTO)
                        .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma turma pelo seu Identificador")
    public ResponseEntity<?> getTurmaById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(turmaMapper.convertToTurmaDTO(turmaService.findById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PostMapping
    @ApiOperation(value = "Cria uma nova Turma")
    public ResponseEntity<?> createTurma(@RequestBody TurmaDTO turmaDTO) {
        try {
            Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
            return new ResponseEntity<>(turmaService.createTurma(turma), HttpStatus.CREATED);
        } catch (ExistingTurmaSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma Turma a partir do seu identificador")
    public TurmaDTO updateTurma(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        return turmaMapper.convertToTurmaDTO(turmaService.updateTurma(id, turma));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma Turma a partir do seu identificador")
    public void deleteCoffee(@PathVariable Long id) {
        turmaService.deleteTurma(id);
    }
    
}
