package com.studentCredWithDb.studentCredWithDb.controller;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassDto;
import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassResponseDto;
import com.studentCredWithDb.studentCredWithDb.service.StudentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student-class")
public class StudentClassController {

    @Autowired
    StudentClassService service;

    @PostMapping("create-student-class")
    public ResponseEntity<StudentClassDto> createStudentClass(@RequestBody StudentClassDto studentClassDto) {
        StudentClassDto response = service.createStudentClass(studentClassDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-student-class/{id}")
    public ResponseEntity<StudentClassDto> updateStudentClass(@PathVariable String id,
                                                              @RequestBody StudentClassDto studentClassDto) {
        StudentClassDto response = service.updateStudentClass(id, studentClassDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete-student-class/{id}")
    public ResponseEntity<String> deleteStudentClass(@PathVariable String id) {
        boolean deleted = service.deleteStudentClass(id);
        String response = deleted ? "deleted" : "no student class found";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-student-class-list")
    public ResponseEntity<List<StudentClassResponseDto>> getStudentClassList(){
        List<StudentClassResponseDto> students = service.getStudentClassList();
        return new ResponseEntity<>(students,HttpStatus.OK);
    }

}
