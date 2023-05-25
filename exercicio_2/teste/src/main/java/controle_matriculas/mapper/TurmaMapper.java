package controle_matriculas.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import controle_matriculas.domain.Turma;
import controle_matriculas.dto.TurmaDTO;
import controle_matriculas.dto.TurmaWithAlunoDTO;
import controle_matriculas.dto.TurmaWithProfessorDTO;

public class TurmaMapper {

    @Autowired
    private ModelMapper modelMapper;
    
    public TurmaDTO convertToTurmaDTO(Turma turma) {
        TurmaDTO turmaDTO = modelMapper.map(turma, TurmaDTO.class);

        return turmaDTO;
    }

    public Turma convertFromTurmaDTO(TurmaDTO turmaDTO) {
        Turma turma = modelMapper.map(turmaDTO, Turma.class);
    
        return turma;
    }

    
    public TurmaWithAlunoDTO convertToTurmaWithAlunoDTO(Turma turma) {
        TurmaWithAlunoDTO turmaDTO = modelMapper.map(turma, TurmaWithAlunoDTO.class);

        return turmaDTO;
    }

    public Turma convertFromTurmaWithAlunoDTO(TurmaDTO turmaDTO) {
        Turma turma = modelMapper.map(turmaDTO, Turma.class);
    
        return turma;
    }

    public TurmaWithProfessorDTO convertToTurmaWithProfessorDTO(Turma turma) {
        TurmaWithProfessorDTO turmaDTO = modelMapper.map(turma, TurmaWithProfessorDTO.class);

        return turmaDTO;
    }

    public Turma convertFromTurmaWithProfessorDTO(TurmaDTO turmaDTO) {
        Turma turma = modelMapper.map(turmaDTO, Turma.class);
    
        return turma;
    }
}
