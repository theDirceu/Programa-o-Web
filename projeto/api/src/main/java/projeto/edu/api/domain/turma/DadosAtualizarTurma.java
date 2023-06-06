package projeto.edu.api.domain.turma;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTurma(
        @NotNull
        Long id,
        String sala) {
}
