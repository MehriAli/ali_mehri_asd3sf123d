package AnywrTest.controller;

import AnywrTest.models.Student;
import AnywrTest.serviceInterfaces.IStudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

    @InjectMocks
    private StudentController studentController;

    @Mock
    private IStudentService studentService;

    @Test
    public void testGetStudents() {
        // Mocked input parameters
        String className = "course one";
        String teacherFullName = "Alex Black";
        int page = 0;
        int size = 10;

        // Mocked list of students using the service method
        List<Student> serviceStudents = studentService.findStudentsByClassNameAndTeacherFullName(className, teacherFullName);

        // Create a page containing the mocked students
        Page<Student> studentPage = new PageImpl<>(serviceStudents);

        // Mock the service method to return the page of students
        Mockito.when(studentService.findAllPageable(className, teacherFullName, page, size)).thenReturn(studentPage);

        // Perform the request to the controller
        Page<Student> result = studentController.getStudents(className, teacherFullName, page, size);

        // Verify that the service method was called with the correct parameters
        Mockito.verify(studentService).findAllPageable(className, teacherFullName, page, size);

        // Assert that the returned result matches the mocked studentPage
        Assert.assertEquals(studentPage, result);
    }
}
