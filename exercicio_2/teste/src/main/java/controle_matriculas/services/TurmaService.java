package controle_matriculas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import controle_matriculas.domain.Turma;
import controle_matriculas.exceptions.ExistingTurmaSameNameException;
import controle_matriculas.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma createTurma(Turma turma) throws ExistingTurmaSameNameException {
        if (turmaRepository.findByName(turma.getName()).isPresent())
            throw new ExistingTurmaSameNameException("Já existe uma turma com esse nome!");
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Long id, Turma turma) {
        turma.setId(id);
        return turmaRepository.save(turma);
    }

    public List<Turma> listAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) throws NotFoundException {
        return turmaRepository.findById(id).orElseThrow(() -> new NotFoundException());
    }

    public void deleteTurma(Long id) {
        Turma turmaToDelete = turmaRepository.findById(id).get();
        turmaRepository.delete(turmaToDelete);
    }    
    
}
