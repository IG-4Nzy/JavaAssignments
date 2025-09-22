package spring1.assignment.spring1.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import spring1.assignment.spring1.model.Student;
import spring1.assignment.spring1.repository.StudentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public Student CreateStudent(Student student){
        return repository.save(student);
    }

    public List<Student> getStudentList(Integer range){
        if(range != null && range > 0){
            return repository.findAll().stream().sorted(Comparator.comparingInt(Student::getRank)).limit(range).collect(Collectors.toList());
        }
        return repository.getAllRecords();
    }

    public Student getStudentById(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(String id,Student student){
        Student existingStudent = repository.findById(id).orElseThrow(() -> new RuntimeException(("No Student Exists")));
        existingStudent.setName(student.getName());
        existingStudent.setMark(student.getMark());
        existingStudent.setRank(student.getRank());
        return repository.save(existingStudent);
    }

    public boolean deleteStudent(@PathVariable  String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
