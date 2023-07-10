package projeto.edu.api.domain.professor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfessor(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank
        String formacao,
        @NotBlank(message = "{email.obrigatorio}")
        @Email
        String email,
        @NotBlank(message = "{matricula.obrigatorio}")
        @Pattern(regexp = "\\d{8}")
        String matricula,
        @NotNull
        FuncoesProfessor funcao) {
}