package projeto.edu.api.turma;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    Page<Turma> findAllByAtivoTrue(Pageable paginacao);
}
