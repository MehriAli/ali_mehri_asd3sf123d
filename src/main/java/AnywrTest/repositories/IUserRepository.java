package AnywrTest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import AnywrTest.security.domain.User;



public interface IUserRepository extends JpaRepository<User, Long> {
List<User> findByUsername(String username);
}
