package AnywrTest.configurations;

import AnywrTest.models.Class;
import AnywrTest.models.Student;
import AnywrTest.models.Teacher;
import AnywrTest.repositories.IClassRepository;
import AnywrTest.repositories.IStudentRepository;
import AnywrTest.repositories.ITeacherRepository;
import AnywrTest.repositories.IUserRepository;
import AnywrTest.security.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class MainConfig {
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "12345";
    private static final String ADMIN_ROLE = "ADMIN";
    private final IUserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final ITeacherRepository teacherRepository;
    private final IStudentRepository studentRepository;
    private final IClassRepository classRepository;

    public MainConfig(IUserRepository userRepository, BCryptPasswordEncoder encoder, ITeacherRepository teacherRepository,
                      IStudentRepository studentRepository, IClassRepository classRepository) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }



    @PostConstruct
    void InitializeData(){
        createAdmin();
        seedDB();
    }

    /**
     * Create a default Administrator if it doesn't exist
     */
    private void createAdmin() {
        if(userRepository.findByUsername(ADMIN_USERNAME).isEmpty()){
            User user = new User(1L,ADMIN_USERNAME, encoder.encode(ADMIN_PASSWORD), ADMIN_ROLE);
            userRepository.save(user);
        }
    }

    /**
     * Inject some data in the DataBase if it's empty
     */
    private void seedDB() {
        if(teacherRepository.findAll().isEmpty() || classRepository.findAll().isEmpty() || studentRepository.findAll().isEmpty()){
            Teacher teacher1 = teacherRepository.save(new Teacher("Alex","Black"));
            Teacher teacher2 = teacherRepository.save(new Teacher("Alexa","White"));

            Class course1 = classRepository.save(new Class("course one",teacher1));
            Class course2 = classRepository.save(new Class("course two",teacher2));
            Class course3 = classRepository.save(new Class("course three",teacher1));
            Class course4 = classRepository.save(new Class("course four",teacher2));

            List<Student> students = new ArrayList<>();
            Student student1 = new Student("Michael","Red",course1);
            Student student2 = new Student("Amine","Brown",course2);
            Student student3 = new Student("Laurent","Purple",course3);
            Student student4 = new Student("Samuel","Blue",course4);
            Student student5 = new Student("Ricard","Pink",course1);
            Student student6 = new Student("Karim","Gray",course2);
            Student student7 = new Student("Ali","Green",course3);
            Student student8 = new Student("Marco","Yellow",course4);
            Student student9 = new Student("Thomas","Gold",course1);
            Student student10 = new Student("Marcel","Silver",course2);
            Student student11 = new Student("Joseph","Bronze",course3);
            Student student12 = new Student("Hana","Chocolate",course4);
            students.add(student1);
            students.add(student2);
            students.add(student3);
            students.add(student4);
            students.add(student5);
            students.add(student6);
            students.add(student7);
            students.add(student8);
            students.add(student9);
            students.add(student10);
            students.add(student11);
            students.add(student12);
            studentRepository.saveAll(students);
        }
    }
}
