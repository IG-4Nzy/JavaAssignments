package com.studentCredWithDb.studentCredWithDb.service;

import com.studentCredWithDb.studentCredWithDb.Dto.SubjectDto;

import java.util.List;

public interface SubjectService {
    public SubjectDto createSubject(SubjectDto subjectDto);
    public SubjectDto updateSubject(String id,SubjectDto subjectDto);
    public boolean deleteSubject(String id);
    public List<SubjectDto> getSubjectList();
}
