package com.studentCredWithDb.studentCredWithDb.Dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDto {
    private String id;
    private String name;
    private Integer rank;
    private String classId;
    private List<SubjectDto> subjects;
}
