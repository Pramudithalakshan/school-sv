package edu.icet.controller;

import edu.icet.dto.StudentDto;
import edu.icet.service.impl.StudentImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentImpl studentService;
    @PostMapping("/add-student")
    public void addStudent(@RequestBody StudentDto student){
        studentService.addStudent(student);
    }
    @GetMapping("/get-students")
    public List<StudentDto> getStudent(){
        return studentService.getStudent();
    }
    @DeleteMapping("/delete-student/{id}")
    public void deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
    }
    @GetMapping("/search-student/{id}")
    public StudentDto searchStudent(@PathVariable Integer id){
        return studentService.searchStudent(id);
    }

}
