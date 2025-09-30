package com.studentCredWithDb.studentCredWithDb.impl;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassDto;
import com.studentCredWithDb.studentCredWithDb.Dto.StudentClassResponseDto;
import com.studentCredWithDb.studentCredWithDb.Dto.SubjectDto;
import com.studentCredWithDb.studentCredWithDb.model.StudentClass;
import com.studentCredWithDb.studentCredWithDb.repository.StudentClassRepository;
import com.studentCredWithDb.studentCredWithDb.repository.SubjectRepository;
import com.studentCredWithDb.studentCredWithDb.service.StudentClassService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentClassServiceImpl implements StudentClassService {

    @Autowired
    StudentClassRepository repository;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public StudentClassDto createStudentClass(StudentClassDto studentClassDto) {
        StudentClass studentClass = new StudentClass();
        studentClass.setId(new ObjectId());
        studentClass.setClassName(studentClassDto.getClassName());
        studentClass.setSubjects(studentClassDto.getSubjects());
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
            studentClass.setSubjects(studentClassDto.getSubjects());
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
    public List<StudentClassResponseDto> getStudentClassList() {
        return repository.findAll().stream().map(s -> {
            StudentClassResponseDto dto = new StudentClassResponseDto();
            dto.setId(s.getId().toString());
            dto.setClassName(s.getClassName());

            List<ObjectId> subjectIds = Optional.ofNullable(s.getSubjects())
                    .stream()
                    .flatMap(List::stream)
                    .filter(ObjectId::isValid)
                    .map(ObjectId::new)
                    .toList();

            List<SubjectDto> subjects = subjectRepository.findAllById(subjectIds)
                    .stream()
                    .map(sub -> {
                SubjectDto subDto = new SubjectDto();
                subDto.setName(sub.getName());
                subDto.setId(sub.getId().toString());
                return subDto;
            }).toList();

            dto.setSubjects(subjects);
            return dto;
        }).toList();
    }
}
