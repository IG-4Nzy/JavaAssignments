package com.studentCredWithDb.studentCredWithDb.controller;

import com.studentCredWithDb.studentCredWithDb.Dto.SubjectDto;
import com.studentCredWithDb.studentCredWithDb.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subjects")
public class SubjectController {

    @Autowired
    SubjectService service;

    @PostMapping("create-subject")
    public ResponseEntity<SubjectDto> createSubject(@RequestBody SubjectDto subjectDto) {
        SubjectDto response = service.createSubject(subjectDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-subject/{id}")
    public ResponseEntity<SubjectDto> updateSubject(@PathVariable String id,
                                                              @RequestBody SubjectDto subjectDto) {
        SubjectDto response = service.updateSubject(id, subjectDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete-subject/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable String id) {
        boolean deleted = service.deleteSubject(id);
        String response = deleted ? "deleted" : "no student class found";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("get-subject-lists")
    public ResponseEntity<List<SubjectDto>> getStudentClassList(){
        List<SubjectDto> subjects = service.getSubjectList();
        return new ResponseEntity<>(subjects,HttpStatus.OK);
    }
}
