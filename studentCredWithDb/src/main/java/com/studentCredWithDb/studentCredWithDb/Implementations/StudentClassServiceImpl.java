package com.studentCredWithDb.studentCredWithDb.Implementations;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassDto;
import com.studentCredWithDb.studentCredWithDb.model.StudentClass;
import com.studentCredWithDb.studentCredWithDb.repository.StudentClassRepository;
import com.studentCredWithDb.studentCredWithDb.service.StudentClassService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    StudentClassRepository repository;

    @Override
    public StudentClassDto createStudentClass(StudentClassDto studentClassDto) {
        StudentClass studentClass = new StudentClass();
        studentClass.setId(new ObjectId());
        studentClass.setClassName(studentClassDto.getClassName());
        repository.save(studentClass);

        studentClassDto.setId(studentClass.getId().toString());
        return studentClassDto;
    }

    @Override
    public StudentClassDto updateStudentClass(String id, StudentClassDto studentClassDto) {
        Optional<StudentClass> optionalStudentClass = repository.findById(new ObjectId(id));
        if(optionalStudentClass.isPresent()){
            StudentClass studentClass = optionalStudentClass.get();
            studentClass.setClassName(studentClassDto.getClassName());
            repository.save(studentClass);
            studentClassDto.setId(studentClass.getId().toString());
            return studentClassDto;
        }else return null;
    }

    @Override
    public boolean deleteStudentClass(String id) {
        ObjectId objId = new ObjectId(id);
        if(repository.existsById(objId)){
            repository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<StudentClassDto> getStudentClassList() {
        return repository.findAll().stream().map(s -> {
            StudentClassDto dto = new StudentClassDto();
            dto.setId(s.getId().toString());
            dto.setClassName(s.getClassName());
            return dto;
        }).toList();
    }
}
