package edu.icet.service;

import edu.icet.dto.StudentDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentService {
    void addStudent(@RequestBody StudentDto student);
    List<StudentDto>getStudent();
    void deleteStudent(Integer id);
    StudentDto searchStudent(Integer id);
}
