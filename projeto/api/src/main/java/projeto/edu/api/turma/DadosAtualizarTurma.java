package projeto.edu.api.turma;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTurma(
        @NotNull
        Long id,
        String sala) {
}
