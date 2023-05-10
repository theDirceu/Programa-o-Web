package controle_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import controle_matriculas.domain.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {}