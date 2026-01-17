package edu.icet.controller;

import edu.icet.dto.ClassesDto;
import edu.icet.service.impl.ClassesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/classes")
public class ClassesController {
    private final ClassesImpl classService;
    @PostMapping("/add-class")
    public void addClass(@RequestBody ClassesDto classesDto){
        classService.addClass(classesDto);
    }
    @GetMapping("/get-classes")
    public List<ClassesDto> getClasses(){
        return classService.getClasses();
    }
    @GetMapping("/search-class/{id}")
    ClassesDto searchClass(@PathVariable Integer id){
        return classService.searchClass(id);
    }
    @DeleteMapping("/delete-class/{id}")
    void deleteClass(@PathVariable Integer id){
        classService.deleteClass(id);
    }
}
