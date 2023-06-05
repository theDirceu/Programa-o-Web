package projeto.edu.api.aluno;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String matricula;

    @Enumerated(EnumType.STRING)
    private FuncoesAluno funcao;

    public Aluno(DadosCadastroAluno dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.matricula = dados.matricula();
        this.funcao = dados.funcao();
    }
}