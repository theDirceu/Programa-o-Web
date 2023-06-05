package projeto.edu.api.aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto.edu.api.aluno.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
