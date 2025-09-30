package com.studentCredWithDb.studentCredWithDb.impl;

import com.studentCredWithDb.studentCredWithDb.Dto.SubjectDto;
import com.studentCredWithDb.studentCredWithDb.model.Subject;
import com.studentCredWithDb.studentCredWithDb.repository.SubjectRepository;
import com.studentCredWithDb.studentCredWithDb.service.SubjectService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectRepository repository;

    @Override
    public SubjectDto createSubject(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setId(new ObjectId());
        subject.setName(subjectDto.getName());
        repository.save(subject);
        subjectDto.setId(subject.getId().toString());
        return subjectDto;
    }

    @Override
    public SubjectDto updateSubject(String id, SubjectDto subjectDto) {
        Optional<Subject> optionalSubject = repository.findById(new ObjectId(id));
        if(optionalSubject.isPresent()){
            Subject subject = optionalSubject.get();
            subject.setName(subjectDto.getName());
            subjectDto.setId(subject.getId().toString());
            repository.save(subject);
            return subjectDto;
        }else return null;
    }

    @Override
    public boolean deleteSubject(String id) {
        ObjectId objId = new ObjectId(id);
        if(repository.existsById(objId)){
            repository.deleteById(objId);
            return true;
        }else return false;
    }

    @Override
    public List<SubjectDto> getSubjectList() {
        return repository.findAll().stream().map(s -> {
            SubjectDto dto = new SubjectDto();
            dto.setId(s.getId().toString());
            dto.setName(s.getName());
            return dto;
        }).toList();
    }
}
