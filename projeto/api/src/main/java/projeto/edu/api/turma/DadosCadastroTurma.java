package projeto.edu.api.turma;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTurma(
        @NotBlank
        String nome,
        @NotBlank
        String sala) {
}
