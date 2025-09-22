package spring1.assignment.spring1.controller;

import org.springframework.web.bind.annotation.*;
import spring1.assignment.spring1.model.Student;
import spring1.assignment.spring1.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("create-student")
    public Student createStudent(@RequestBody Student student) {
        return service.CreateStudent(student);
    }

    @PutMapping("update-student/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @GetMapping("get-student-list")
    public List<Student> getStudentsList(@RequestParam(required = false) Integer range) {
        return service.getStudentList(range);
    }

    @DeleteMapping("delete-student/{id}")
    public String deleteStudent(@PathVariable  String id) {
        boolean isDeleted = service.deleteStudent(id);
        return isDeleted ? "Deleted successfully" : "Error occurred";
    }
}