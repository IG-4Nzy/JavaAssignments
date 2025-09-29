package com.studentCredWithDb.studentCredWithDb.controller;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentDto;
import com.studentCredWithDb.studentCredWithDb.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("create-student")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
        StudentDto response = service.createStudent(studentDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-student/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable String id,
                                                    @RequestBody StudentDto studentDto) {
        StudentDto response = service.updateStudent(id, studentDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete-student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id) {
        boolean deleted = service.deleteStudent(id);
        String response = deleted ? "Deleted" : "Student not found";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-students-list")
        public ResponseEntity<List<StudentDto>> getStudentsList(@RequestParam(required = false) Integer topNRange ){
        List<StudentDto> response = service.getStudentsList(topNRange);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
