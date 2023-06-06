package projeto.edu.api.domain.projeto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProjeto(
        @NotBlank
        String nome,
        @NotBlank
        String descricao) {
}
