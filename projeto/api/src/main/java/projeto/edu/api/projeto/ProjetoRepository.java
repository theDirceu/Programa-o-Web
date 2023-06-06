package projeto.edu.api.projeto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    Page<Projeto> findAllByAtivoTrue(Pageable paginacao);

}
