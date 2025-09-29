package com.studentCredWithDb.studentCredWithDb.Dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
@Data
public class StudentDto {
    private String id;
    private String name;
    private Integer rank;
}
