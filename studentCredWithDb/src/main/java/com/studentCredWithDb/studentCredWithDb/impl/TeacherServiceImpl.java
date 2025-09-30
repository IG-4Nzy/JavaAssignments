package com.studentCredWithDb.studentCredWithDb.impl;

import com.studentCredWithDb.studentCredWithDb.Dto.TeacherDto;
import com.studentCredWithDb.studentCredWithDb.model.Teacher;
import com.studentCredWithDb.studentCredWithDb.repository.TeacherRepository;
import com.studentCredWithDb.studentCredWithDb.service.TeacherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository repository;

    @Override
    public TeacherDto createTeacher(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(new ObjectId());
        teacher.setName(teacherDto.getName());
        teacher.setSubjectId(teacherDto.getSubjectId());
        repository.save(teacher);
        teacherDto.setId(teacher.getId().toString());
        return teacherDto;
    }

    @Override
    public TeacherDto updateTeacher(String id, TeacherDto teacherDto) {
        Optional<Teacher> optionalTeacher = repository.findById(new ObjectId(id));
        if(optionalTeacher.isPresent()){
            Teacher teacher =  optionalTeacher.get();
            teacher.setName(teacherDto.getName());
            teacher.setSubjectId(teacherDto.getSubjectId());
            repository.save(teacher);

            TeacherDto dto = new TeacherDto();
            dto.setId(teacher.getId().toString());
            dto.setName(teacher.getName());
            dto.setSubjectId(teacher.getSubjectId());
            return dto;
        }else return null;
    }

    @Override
    public boolean deleteTeacher(String id) {
        ObjectId objId = new ObjectId(id);
        if(repository.existsById(objId)){
            repository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<TeacherDto> getTeacherList(String id, String subjectId) {
        return repository.findAll()
                .stream()
                .filter(t ->id == null || t.getId().toString().equals(id))
                .filter(t -> subjectId == null || t.getSubjectId().equals(subjectId))
                .map(t ->{
                    TeacherDto dto = new TeacherDto();
                    dto.setId(t.getId().toString());
                    dto.setName(t.getName());
                    dto.setSubjectId(t.getSubjectId());
                    return dto;
                }).toList();
    }
}
