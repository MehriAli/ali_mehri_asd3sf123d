package AnywrTest.repositories;

import AnywrTest.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ITeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("select t from Teacher t where concat(t.firstName, ' ', t.lastName) = :fullName")
    Optional<Teacher> findByFullName(@Param("fullName") String fullName);
}
