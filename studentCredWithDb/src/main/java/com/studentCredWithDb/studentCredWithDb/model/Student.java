package com.studentCredWithDb.studentCredWithDb.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Student {
    @Id
    private ObjectId id;
    private String name;
    private Integer rank;
}
