package projeto.edu.api.domain.professor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProfessor(
        @NotNull
        Long id,
        String nome,
        String formacao,
        FuncoesProfessor funcao) {

}
