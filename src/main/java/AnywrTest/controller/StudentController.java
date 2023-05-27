package AnywrTest.controller;

import AnywrTest.models.Student;
import AnywrTest.serviceInterfaces.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("/list")
    public Page<Student> getStudents(@RequestParam(required = false) String className,
                                     @RequestParam(required = false) String teacherFullName,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size){

        return studentService.findAllPageable(className,teacherFullName,page,size);
    }

}
