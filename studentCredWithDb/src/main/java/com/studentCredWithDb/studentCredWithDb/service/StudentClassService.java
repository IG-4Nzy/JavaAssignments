package com.studentCredWithDb.studentCredWithDb.service;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassDto;
import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassResponseDto;

import java.util.List;

public interface StudentClassService {
    public StudentClassDto createStudentClass(StudentClassDto studentClassDto);
    public StudentClassDto updateStudentClass(String id,StudentClassDto studentClassDto);
    public boolean deleteStudentClass(String id);
    public List<StudentClassResponseDto> getStudentClassList();
}
