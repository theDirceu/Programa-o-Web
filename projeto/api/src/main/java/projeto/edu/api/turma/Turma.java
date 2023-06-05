package projeto.edu.api.turma;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "turmas")
@Entity(name = "Turma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Turma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sala;

    public Turma(DadosCadastroTurma dados){
        this.nome = dados.nome();
        this.sala = dados.sala();
    }
}
