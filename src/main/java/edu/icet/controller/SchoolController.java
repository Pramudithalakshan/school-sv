package edu.icet.controller;

import edu.icet.dto.SchoolDto;
import edu.icet.service.impl.SchoolImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/school")
public class SchoolController {
    private final SchoolImpl schoolService;
    @PostMapping("/add-school")
    public void addStudent(@RequestBody SchoolDto student) {
        schoolService.addSchool(student);
    }
    @GetMapping("/get-school")
    public List<SchoolDto> getSchool() {
        return  schoolService.getSchool();
    }
    @DeleteMapping("/delete-school")
    public void deleteStudent(Integer id) {
        schoolService.deleteSchool(id);
    }
    @GetMapping("/search-school")
    public SchoolDto searchStudent(Integer id) {
        return schoolService.searchSchool(id);
    }
}
