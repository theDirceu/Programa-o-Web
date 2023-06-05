package projeto.edu.api.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,
        @NotBlank
        String formacao,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String matricula,
        @NotNull
        FuncoesProfessor funcao) {
}
