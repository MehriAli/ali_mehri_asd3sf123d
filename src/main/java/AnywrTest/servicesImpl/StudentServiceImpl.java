package AnywrTest.servicesImpl;

import AnywrTest.models.Class;
import AnywrTest.models.Student;
import AnywrTest.models.Teacher;
import AnywrTest.repositories.IClassRepository;
import AnywrTest.repositories.IStudentRepository;
import AnywrTest.repositories.ITeacherRepository;
import AnywrTest.serviceInterfaces.IStudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;
    private final IClassRepository classRepository;
    private final ITeacherRepository teacherRepository;

    public StudentServiceImpl(IStudentRepository studentRepository, IClassRepository classRepository, ITeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.teacherRepository = teacherRepository;
    }
    @Override
    public Page<Student> findAllPageable(String className, String teacherFullName, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Class classEntity = null;
        Teacher teacherEntity = null;

        /**
         * chercher les elements de filtre
         */
        if(teacherRepository.findByFullName(teacherFullName).isPresent()){
            teacherEntity = teacherRepository.findByFullName(teacherFullName).get();
        }
        if(classRepository.findClassByName(className).isPresent()){
            classEntity = classRepository.findClassByName(className).get();
        }

        return studentRepository.findAllByClassAndTeacher(classEntity, teacherEntity, pageable);
    }


    /**
     *
     * @param className
     * @param teacherFullName
     * @return List of Student for unit test using
     */

    @Override
    public List<Student> findStudentsByClassNameAndTeacherFullName(String className, String teacherFullName) {
        Class classEntity = null;
        Teacher teacherEntity = null;

        if(teacherRepository.findByFullName(teacherFullName).isPresent()){
            teacherEntity = teacherRepository.findByFullName(teacherFullName).get();
        }
        if(classRepository.findClassByName(className).isPresent()){
            classEntity = classRepository.findClassByName(className).get();
        }
        return studentRepository.findByCourseAndTeacher(classEntity, teacherEntity);
    }

}
