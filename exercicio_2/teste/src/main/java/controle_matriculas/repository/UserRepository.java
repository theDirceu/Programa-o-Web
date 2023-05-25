package controle_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import controle_matriculas.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    
}