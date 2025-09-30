package com.studentCredWithDb.studentCredWithDb.Dto;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class StudentClassDto {
    private String id;
    private String className;
    private List<String> subjects;
}
