package AnywrTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Student")
public class Student {

    @Id
    @GeneratedValue
    private Long ID;
    private String firstName;
    private String lastName;

    @ManyToOne
    private Class course;

    public Student(String firstName, String lastName, Class course) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }
}
