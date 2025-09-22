package spring1.assignment.spring1.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private Integer rank;
    private double mark;

    public Student() {
    }

    public Student(String name, Integer rank, double mark) {
        this.name = name;
        this.rank = rank;
        this.mark = mark;
    }

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getRank(){
        return rank;
    }
    public void setRank(Integer rank){
        this.rank = rank;
    }

    public double getMark(){
        return mark;
    }
    public void setMark(double mark){
        this.mark = mark;
    }

}
