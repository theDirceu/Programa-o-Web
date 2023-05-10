package controle_matriculas.model;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Turma {
    
    private String id;
    private String nome_turma;

    public Turma(String name){
        this.id = UUID.randomUUID().toString();
        this.nome_turma = name;
    }

    public String getName() {
        return null;
    }

    public void add(Turma newturma) {
    }
}
