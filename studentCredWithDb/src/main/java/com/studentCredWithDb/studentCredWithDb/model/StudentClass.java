package com.studentCredWithDb.studentCredWithDb.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "studentClass")
@Data
public class StudentClass {
    @Id
    private ObjectId id;
    private String className;
    private List<String> subjects;
}
