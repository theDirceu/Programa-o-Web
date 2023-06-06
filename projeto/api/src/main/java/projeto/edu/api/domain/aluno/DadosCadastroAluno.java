package projeto.edu.api.domain.aluno;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroAluno(
        @NotBlank(message = "{nome.obrigatorio}")
        String nome,
        @NotBlank(message = "{email.obrigatorio}")
        @Email
        String email,
        @NotBlank(message = "{matricula.obrigatorio}")
        @Pattern(regexp = "\\d{8}")
        String matricula,
        @NotNull
        FuncoesAluno funcao) {
}
