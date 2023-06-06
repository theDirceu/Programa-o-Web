package projeto.edu.api.domain.turma;

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

    private Boolean ativo;

    public Turma(DadosCadastroTurma dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.sala = dados.sala();
    }

    public void atualizarInfomacoes(DadosAtualizarTurma dados) {
        if (dados.sala() !=null) {
            this.sala = dados.sala();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
