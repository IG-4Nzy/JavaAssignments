package com.studentCredWithDb.studentCredWithDb.service;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentDto;
import com.studentCredWithDb.studentCredWithDb.Dto.StudentResponseDto;
import org.bson.types.ObjectId;

import java.util.List;

public interface StudentService {
    public StudentDto createStudent(StudentDto studentDto);
    public StudentDto updateStudent(String id,StudentDto studentDto);
    public boolean deleteStudent(String id);
    public List<StudentResponseDto> getStudentsList(Integer topNrange, String name, String classId,Integer rank);
}
