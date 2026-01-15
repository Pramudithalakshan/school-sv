package edu.icet.service;

import edu.icet.dto.StudentDto;
import edu.icet.entity.Student;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    void addStudent(@RequestBody StudentDto student);
    List<StudentDto>getStudent();
    void deleteStudent(Integer id);
    Optional<StudentDto> searchStudent(Integer id);
}
