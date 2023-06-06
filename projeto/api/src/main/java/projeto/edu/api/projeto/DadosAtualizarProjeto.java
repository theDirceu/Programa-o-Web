package projeto.edu.api.projeto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProjeto(
        @NotNull
        Long id,
        String descricao) {
}
