package com.studentCredWithDb.studentCredWithDb.Implementations;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentDto;
import com.studentCredWithDb.studentCredWithDb.model.Student;
import com.studentCredWithDb.studentCredWithDb.repository.StudentRepository;
import com.studentCredWithDb.studentCredWithDb.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setRank(studentDto.getRank());
        student.setId(new ObjectId());
        repository.save(student);
        studentDto.setId(student.getId().toString());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(String id, StudentDto studentDto) {
        ObjectId objId = new ObjectId(id);
        Optional<Student> optionalStudent = repository.findById(objId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDto.getName());
            student.setRank(studentDto.getRank());
            repository.save(student);

            StudentDto dto = new StudentDto();
            dto.setName(student.getName());
            dto.setId(student.getId().toString());
            dto.setRank(studentDto.getRank());

            return dto;
        } else return null;
    }

    @Override
    public boolean deleteStudent(String id) {
        ObjectId objId = new ObjectId(id);
        if (repository.existsById(objId)) {
            repository.deleteById(objId);
            return true;
        } else return false;
    }

    @Override
    public List<StudentDto> getStudentsList(Integer topNrange) {
        List<Student> studentsList = repository.findAll();
        return studentsList.stream()
                .sorted(Comparator.comparingInt(Student::getRank))
                .limit(topNrange == null ? studentsList.size() : topNrange)
                .map(s -> {
                    StudentDto dto = new StudentDto();
                    dto.setId(s.getId().toString());
                    dto.setName(s.getName());
                    dto.setRank(s.getRank());
                    return dto;
                }).toList();
    }

}
