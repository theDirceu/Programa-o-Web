package controle_matriculas.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;

import controle_matriculas.domain.Turma;
import controle_matriculas.dto.TurmaDTO;

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
    
}
