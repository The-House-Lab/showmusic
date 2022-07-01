package br.com.showmusic.app.repository;

import br.com.showmusic.app.model.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserLogin, Long> {
    List<UserLogin> findAllByUsernameContainingIgnoreCase(String username);
    Optional<List <UserLogin>> findAllByUsername(String username);
    List<UserLogin> findAll();
}
