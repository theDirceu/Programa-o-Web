package controle_matriculas.dto;

import java.sql.Time;

import lombok.Data;

@Data
public class TurmaDTO {

    private String name;

    private long id;

    private Time horario;
    
}
