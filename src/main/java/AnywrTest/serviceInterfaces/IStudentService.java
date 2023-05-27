package AnywrTest.serviceInterfaces;

import AnywrTest.models.Student;
import org.springframework.data.domain.Page;
import java.util.List;

public interface IStudentService {
    Page<Student> findAllPageable(String className, String teacherFullName, int page, int size);
    List<Student> findStudentsByClassNameAndTeacherFullName(String className, String teacherFullName);
}
