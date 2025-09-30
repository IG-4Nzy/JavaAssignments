package com.studentCredWithDb.studentCredWithDb.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teachers")
@Data
public class Teacher {
    @Id
    private ObjectId id;
    private String name;
    private String subjectId;
}
