package com.studentCredWithoutDb.studentCredWithoutDb.Implementations;

import com.studentCredWithoutDb.studentCredWithoutDb.DTO.StudentDto;
import com.studentCredWithoutDb.studentCredWithoutDb.model.Student;
import com.studentCredWithoutDb.studentCredWithoutDb.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentImpl implements StudentService {

    private final List<Student> studentsList = new ArrayList<>();
    private final AtomicInteger uniqueId = new AtomicInteger(1);

    @Override
    public String createStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(String.valueOf(uniqueId.getAndIncrement()));
        student.setName(studentDto.getName());
        student.setDepartment(studentDto.getDepartment());
        student.setRollNum(studentDto.getRollNum());
        studentsList.add(student);
        return "student created";
    }

    @Override
    public String updateStudent(String id, StudentDto studentDto) {
        for (Student s : studentsList) {
            if (s.getId().equals(id)) {
                s.setName(studentDto.getName());
                s.setDepartment(studentDto.getDepartment());
                s.setRollNum(studentDto.getRollNum());
                return "Student updated";
            }
        }
        return "Student with id not found";

    }

    @Override
    public boolean deleteStudent(String id) {
        return studentsList.removeIf(s -> s.getId().equals(id));
    }

    @Override
    public List<StudentDto> getStudentList() {

        List<StudentDto> dtoList = new ArrayList<>();
        for (Student s : studentsList) {
            StudentDto dto = new StudentDto();
            dto.setId(s.getId());
            dto.setName(s.getName());
            dto.setRollNum(s.getRollNum());
            dto.setDepartment(s.getDepartment());
            dtoList.add(dto);
        }
        return dtoList;
    }
}
