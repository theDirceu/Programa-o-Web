package projeto.edu.api.domain.professor;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "professores")
@Entity(name = "Professor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Professor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String formacao;
    private String email;
    private String matricula;

    @Enumerated(EnumType.STRING)
    private FuncoesProfessor funcao;

    private Boolean ativo;

    public Professor(DadosCadastroProfessor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.formacao = dados.formacao();
        this.matricula = dados.matricula();
        this.funcao = dados.funcao();
    }

    public void atualizarInfomacoes(DadosAtualizarProfessor dados) {
        if (dados.nome() !=null) {
            this.nome = dados.nome();
        }
        if (dados.funcao() != null) {
            this.funcao = dados.funcao();
        }
        if (dados.formacao() != null) {
            this.formacao = dados.formacao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
