package controle_matriculas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controle_matriculas.model.Turma;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private List<Turma> turmas = new ArrayList<>();

    @GetMapping
    public List<Turma> getTurmas(){
        return turmas;
    }

    @GetMapping("/{id}")
    public Optional<Turma> getTurmaById(@PathVariable String id) {
        for (Turma turma : turmas) {
            if (turma.getId().equals(id))
                return Optional.of(turma);
        }

        return Optional.empty();
    }

    @PostMapping
    public Turma createTurma(@RequestBody Turma turma) {
        Turma newTurma = new Turma(turma.getName());
        turma.add(newTurma);
        return newTurma;
    }

    @PutMapping("/{id}")
    public Turma updateTurma(@PathVariable("id") String id, @RequestBody Turma turma) {
        int turmaIndex = -1;
        Turma updatedTurma = new Turma(turma.getName());

        for (Turma c : turmas) {
            if (c.getId().equals(id)) {
                turmaIndex = turmas.indexOf(c);
                turmas.set(turmaIndex, updatedTurma);
            }
        }

        return (turmaIndex == -1) ? createTurma(turma) : updatedTurma;
    }

    @DeleteMapping("/{id}")
    public void deleteTurma(@PathVariable String id) {
        turmas.removeIf(c -> c.getId().equals(id));
    } 
    
}
