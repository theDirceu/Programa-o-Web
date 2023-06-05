package controle_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import controle_matriculas.domain.Turma;

import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import controle_matriculas.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

    Optional<Turma> findByName(Object object);
}