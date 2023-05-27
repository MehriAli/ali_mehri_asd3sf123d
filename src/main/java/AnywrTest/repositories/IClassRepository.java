package AnywrTest.repositories;

import AnywrTest.models.Class;
import AnywrTest.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IClassRepository extends JpaRepository<Class, Long> {
    Optional<Class> findClassByName(String name);
}
