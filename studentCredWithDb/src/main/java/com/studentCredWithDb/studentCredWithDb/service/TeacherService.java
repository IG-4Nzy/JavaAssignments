package com.studentCredWithDb.studentCredWithDb.service;

import com.studentCredWithDb.studentCredWithDb.Dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    public TeacherDto createTeacher(TeacherDto teacherDto);
    public TeacherDto updateTeacher(String id,TeacherDto teacherDto);
    public boolean deleteTeacher(String id);
    public List<TeacherDto> getTeacherList(String id,String subjectId);
}
