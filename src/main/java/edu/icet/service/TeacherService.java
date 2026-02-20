package edu.icet.service;

import edu.icet.dto.TeacherDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TeacherService {
    void add(TeacherDto dto);
    Page<@NotNull TeacherDto> getAll(Pageable pageable);
    TeacherDto getTeacher(Integer id);
    void delete(Integer id);
    TeacherDto update(TeacherDto dto,Integer id);
}
