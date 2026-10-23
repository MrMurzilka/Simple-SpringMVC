package zdal.spring_boot_rest_serviceforstudents_withh2.controller;

import org.springframework.web.bind.annotation.*;
import zdal.spring_boot_rest_serviceforstudents_withh2.model.Student;
import zdal.spring_boot_rest_serviceforstudents_withh2.repository.StudentRepository;

import java.util.List;

@RestController
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //Create
    @PostMapping("/student")
    Student newStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    //ReadOne
    @GetMapping("/student/{id}")
    Student getStudent(@PathVariable Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    //ReadAll
    @GetMapping("/students")
    List<Student> getStudents() {
        return studentRepository.findAll();
    }

    //Delete
    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
    }

    //Update
    @PutMapping("/student/{id}")
    Student updateStudent(@RequestBody Student newStudent, @PathVariable Integer id) {
        return studentRepository.findById(id).map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    student.setDepartment(newStudent.getDepartment());
                    student.setEnrollment(newStudent.getEnrollment());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> studentRepository.save(newStudent));
    }
}
