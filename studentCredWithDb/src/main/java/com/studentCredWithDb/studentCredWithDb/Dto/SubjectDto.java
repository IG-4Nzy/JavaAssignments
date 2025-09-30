package com.studentCredWithDb.studentCredWithDb.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubjectDto {
    @Id
    private String id;
    private String name;
    private Integer mark;
}
