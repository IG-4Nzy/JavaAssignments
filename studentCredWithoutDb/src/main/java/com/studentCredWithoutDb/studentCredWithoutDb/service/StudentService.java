package com.studentCredWithoutDb.studentCredWithoutDb.service;

import com.studentCredWithoutDb.studentCredWithoutDb.DTO.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    public String createStudent(StudentDto student);
    public String updateStudent(String id,StudentDto student);
    public boolean deleteStudent(String id);
    public List<StudentDto> getStudentList();
    public List<StudentDto> getTopThreeStudentsList();
}
