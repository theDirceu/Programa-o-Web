package projeto.edu.api.professor;

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

    public Professor(DadosCadastroProfessor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.formacao = dados.formacao();
        this.matricula = dados.matricula();
        this.funcao = dados.funcao();
    }
}
