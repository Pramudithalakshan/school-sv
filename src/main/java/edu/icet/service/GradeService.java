package edu.icet.service;

import edu.icet.dto.GradeDto;

import java.util.List;

public interface GradeService {
    void addGrade(GradeDto gradeDto);
    List<GradeDto> getGrades();
    GradeDto searchGrade(Integer id);
    void deleteGrade(Integer id);
}
