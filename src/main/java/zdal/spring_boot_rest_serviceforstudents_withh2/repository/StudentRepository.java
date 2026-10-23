package zdal.spring_boot_rest_serviceforstudents_withh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zdal.spring_boot_rest_serviceforstudents_withh2.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
