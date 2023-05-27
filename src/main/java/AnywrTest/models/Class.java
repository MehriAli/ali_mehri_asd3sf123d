package AnywrTest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Class")
public class Class {
    @Id
    @GeneratedValue
    private Long ID;
    private String name;
    @ManyToOne
    private Teacher teacher;

    public Class(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }
}
