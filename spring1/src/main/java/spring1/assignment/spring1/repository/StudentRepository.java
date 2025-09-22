package spring1.assignment.spring1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import spring1.assignment.spring1.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository <Student,String>{
    default List<Student> getAllRecords() {
        return findAll();
    }
}
