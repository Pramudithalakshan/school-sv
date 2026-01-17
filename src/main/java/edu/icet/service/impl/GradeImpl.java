package edu.icet.service.impl;

import edu.icet.dto.GradeDto;
import edu.icet.entity.Grade;
import edu.icet.mapper.GradeMapper;
import edu.icet.repository.GradeRepository;
import edu.icet.service.GradeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GradeImpl implements GradeService {
    private final GradeMapper gradeMapper;
    private final GradeRepository repository;
    @Override
    public void addGrade(GradeDto gradeDto) {
        repository.save(gradeMapper.toEntity(gradeDto));
    }

    @Override
    public List<GradeDto> getGrades() {
        return gradeMapper.toDtos(repository.findAll());
    }

    @Override
    public GradeDto searchGrade(Integer id) {
        Grade grade = repository.findById(id).orElseThrow(() ->new RuntimeException("grade not found"));
        return gradeMapper.toDto(grade);
    }

    @Override
    public void deleteGrade(Integer id) {
        repository.deleteById(id);
    }
}
