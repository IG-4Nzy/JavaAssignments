package com.studentCredWithoutDb.studentCredWithoutDb.controller;

import com.studentCredWithoutDb.studentCredWithoutDb.DTO.StudentDto;
import com.studentCredWithoutDb.studentCredWithoutDb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDto student) {
        String message = service.createStudent(student);
        return new ResponseEntity<String>(message, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable String id, @RequestBody StudentDto student) {
        String message = service.updateStudent(id, student);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam(required = true) String id) {
        boolean deleted = service.deleteStudent(id);
        String message = deleted ? "Student deleted" : " No student found";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentList() {
        List<StudentDto> students = service.getStudentList();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("get-top-three")
    public ResponseEntity<List<StudentDto>> getTopThreeRankedStudents() {
        List<StudentDto> students = service.getTopThreeStudentsList();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

}
