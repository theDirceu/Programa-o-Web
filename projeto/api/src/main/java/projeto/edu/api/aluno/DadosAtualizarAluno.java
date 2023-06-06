package projeto.edu.api.aluno;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarAluno(
        @NotNull
        Long id,
        String nome,
        FuncoesAluno funcao) {

}
