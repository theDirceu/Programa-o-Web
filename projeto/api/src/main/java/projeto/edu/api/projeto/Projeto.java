package projeto.edu.api.projeto;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "projetos")
@Entity(name = "Projeto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Projeto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;

    public Projeto (DadosCadastroProjeto dados){
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }
}
