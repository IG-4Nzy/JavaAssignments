package com.studentCredWithDb.studentCredWithDb.Dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentClassResponseDto {
    private String id;
    private String className;
    private List<SubjectDto> subjects;
}