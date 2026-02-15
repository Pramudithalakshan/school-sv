package edu.icet.service;

import edu.icet.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    void addTeacher(TeacherDto dto);
    List<TeacherDto> getTeachers();
    TeacherDto searchTeacher(Integer id);
    void deleteTeacher(Integer id);
}
