package com.studentCredWithDb.studentCredWithDb.Dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class TeacherDto {
    @Id
    private String id;
    private String name;
    private String subjectId;
}

