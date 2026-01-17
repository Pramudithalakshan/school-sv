package edu.icet.controller;

import edu.icet.dto.GradeDto;
import edu.icet.service.impl.GradeImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("grade")
public class GradeController {
    private final GradeImpl gradeService;
    @PostMapping("/add-grade")
    public void addGrade(@RequestBody GradeDto gradeDto){
        gradeService.addGrade(gradeDto);
    }
    @GetMapping("/get-grades")
    public List<GradeDto> getGrades(){
        return gradeService.getGrades();
    }
    @GetMapping("/search-grade/{id}")
    public GradeDto searchGrade(@PathVariable Integer id){
        return gradeService.searchGrade(id);
    }
    @DeleteMapping("/delete-grade/{id}")
    public void deleteGrade(@PathVariable Integer id){
        gradeService.deleteGrade(id);
    }
}
