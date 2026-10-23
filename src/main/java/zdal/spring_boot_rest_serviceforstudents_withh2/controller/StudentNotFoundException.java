package zdal.spring_boot_rest_serviceforstudents_withh2.controller;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer id) {
        super("Student with id " + id + " not found");
    }
}
