package com.studentCredWithDb.studentCredWithDb.controller;

import com.studentCredWithDb.studentCredWithDb.Dto.TeacherDto;
import com.studentCredWithDb.studentCredWithDb.model.Teacher;
import com.studentCredWithDb.studentCredWithDb.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {

    @Autowired
    TeacherService service;

    @PostMapping("create-teacher")
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto response = service.createTeacher(teacherDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update-teacher/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable String id,
                                                    @RequestBody TeacherDto teacherDto){
        TeacherDto response = service.updateTeacher(id,teacherDto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("delete-teacher/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable String id){
        boolean deleted = service.deleteTeacher(id);
        String message = deleted ? "deleted" : "no Teacher found";
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @GetMapping("get-teachers")
    public ResponseEntity<List<TeacherDto>> getTeachersList(@RequestParam(required = false) String id,
                                                            @RequestParam(required = false) String subjectId){
        List<TeacherDto> response = service.getTeacherList(id,subjectId);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
