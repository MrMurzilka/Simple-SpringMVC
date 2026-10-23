package zdal.spring_boot_rest_serviceforstudents_withh2.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String department;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate enrollment;

    public Student() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(this.id, student.id) && Objects.equals(this.firstName, student.firstName) && Objects.equals(this.lastName, student.lastName)  && Objects.equals(this.department, student.department) && Objects.equals(this.enrollment, student.enrollment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.firstName, this.lastName, this.department, this.enrollment);
    }

    @Override
    public String toString() {
        return "Student{" + "firstName: " + firstName + '}';
    }
}
