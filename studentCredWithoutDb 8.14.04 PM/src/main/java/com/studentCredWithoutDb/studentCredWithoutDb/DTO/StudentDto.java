package com.studentCredWithoutDb.studentCredWithoutDb.DTO;

public class StudentDto {
    private String id;
    private String name;
    private String department;
    private Integer rollNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getRollNum() {
        return rollNum;
    }

    public void setRollNum(Integer rollNum) {
        this.rollNum = rollNum;
    }

    public StudentDto(){};

    public StudentDto (String id,String name,String department,Integer rollNum){
        this.id = id;
        this.name = name;
        this.department = department;
        this.rollNum = rollNum;
    };
}
