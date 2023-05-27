package AnywrTest.repositories;

import AnywrTest.models.Student;
import AnywrTest.models.Teacher;
import AnywrTest.models.Class;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {

    @Query("SELECT s FROM Student s WHERE (:classEntity IS NULL OR s.course = :classEntity) " +
            "AND (:teacherEntity IS NULL OR s.course.teacher = :teacherEntity)")
    Page<Student> findAllByClassAndTeacher(@Param("classEntity") Class classEntity, @Param("teacherEntity") Teacher teacherEntity, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.course = :classEntity AND s.course.teacher = :teacherEntity")
    List<Student> findByCourseAndTeacher(@Param("classEntity") Class classEntity, @Param("teacherEntity") Teacher teacherEntity);
}
