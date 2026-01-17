package edu.icet.mapper;

import edu.icet.dto.GradeDto;
import edu.icet.entity.Grade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradeMapper {
    GradeDto toDto(Grade grade);
    Grade toEntity(GradeDto gradeDto);
    @Mapping(source = "grade.id",target = "gradeId")
    List<GradeDto> toDtos(List<Grade> grades);
    @Mapping(source = "grade.id",target = "gradeId")
    List<Grade> toEnties(List<GradeDto> gradeDtos);
}
