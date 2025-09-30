package com.studentCredWithDb.studentCredWithDb.impl;

import com.studentCredWithDb.studentCredWithDb.Dto.StudentDto;
import com.studentCredWithDb.studentCredWithDb.Dto.StudentResponseDto;
import com.studentCredWithDb.studentCredWithDb.Dto.SubjectDto;
import com.studentCredWithDb.studentCredWithDb.model.Student;
import com.studentCredWithDb.studentCredWithDb.model.StudentClass;
import com.studentCredWithDb.studentCredWithDb.repository.StudentClassRepository;
import com.studentCredWithDb.studentCredWithDb.repository.StudentRepository;
import com.studentCredWithDb.studentCredWithDb.repository.SubjectRepository;
import com.studentCredWithDb.studentCredWithDb.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;
    @Autowired
    private StudentClassRepository classRepository;
    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(new ObjectId());
        student.setName(studentDto.getName());
        student.setRank(studentDto.getRank());
        student.setClassId(studentDto.getClassId());
        student.setSubjects(studentDto.getSubjects());
        repository.save(student);

        studentDto.setId(student.getId().toString());
        return studentDto;
    }

    @Override
    public StudentDto updateStudent(String id, StudentDto studentDto) {
        ObjectId objId = new ObjectId(id);
        return repository.findById(objId)
                .map(student -> {
                    student.setName(studentDto.getName());
                    student.setRank(studentDto.getRank());
                    student.setClassId(studentDto.getClassId());
                    if (studentDto.getSubjects() == null) {
                        Optional<StudentClass> optionalClass = classRepository.findById(new ObjectId(student.getClassId()));

                        optionalClass.ifPresent(cls -> {
                            Map<String, Integer> subjectsWithMarks = new HashMap<>();
                            if (cls.getSubjects() != null) {
                                cls.getSubjects().forEach(subId -> subjectsWithMarks.put(subId, 0));
                            }
                            student.setSubjects(subjectsWithMarks);
                        });
                    } else student.setSubjects(studentDto.getSubjects());

                    repository.save(student);
                    return toStudentDto(student);
                }).orElse(null);
    }

    @Override
    public boolean deleteStudent(String id) {
        ObjectId objId = new ObjectId(id);
        if (repository.existsById(objId)) {
            repository.deleteById(objId);
            return true;
        }
        return false;
    }

    @Override
    public List<StudentResponseDto> getStudentsList(Integer topNrange, String name, String classId,Integer rank) {
        return repository.findAll().stream()
                .filter(s -> name == null || s.getName().toLowerCase().contains(name.toLowerCase()))
                .filter(s -> classId == null || s.getClassId().toString().equals(classId))
                .filter(s -> rank == null || s.getRank().equals(rank))
                .sorted(Comparator.comparingInt(Student::getRank))
                .limit(topNrange == null ? Long.MAX_VALUE : topNrange)
                .map(this::toStudentResponseDto)
                .collect(Collectors.toList());
    }

    private StudentDto toStudentDto(Student student) {
        StudentDto dto = new StudentDto();
        dto.setId(student.getId().toString());
        dto.setName(student.getName());
        dto.setRank(student.getRank());
        dto.setClassId(student.getClassId());
        dto.setSubjects(student.getSubjects());
        return dto;
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId().toString());
        dto.setName(student.getName());
        dto.setRank(student.getRank());

        dto.setClassId(classRepository.findById(new ObjectId(student.getClassId()))
                .map(StudentClass::getClassName)
                .orElse(student.getClassId()));

        Map<String, Integer> studentSubjects = Optional.ofNullable(student.getSubjects())
                .orElse(Collections.emptyMap());

        List<SubjectDto> subjects = subjectRepository.findAllById(
                        studentSubjects.keySet().stream()
                                .filter(Objects::nonNull)
                                .filter(ObjectId::isValid)
                                .map(ObjectId::new)
                                .collect(Collectors.toList()))
                .stream()
                .map(sub -> {
                    SubjectDto subDto = new SubjectDto();
                    subDto.setId(sub.getId().toString());
                    subDto.setName(sub.getName());
                    subDto.setMark(studentSubjects.getOrDefault(sub.getId().toString(), 0));
                    return subDto;
                })
                .collect(Collectors.toList());

        dto.setSubjects(subjects);
        return dto;
    }
}
