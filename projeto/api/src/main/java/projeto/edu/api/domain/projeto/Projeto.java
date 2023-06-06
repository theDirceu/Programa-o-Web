package projeto.edu.api.domain.projeto;

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

    private Boolean ativo;

    public Projeto (DadosCadastroProjeto dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }

    public void atualizarInfomacoes(DadosAtualizarProjeto dados) {
        if (dados.descricao() !=null) {
            this.nome = dados.descricao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
