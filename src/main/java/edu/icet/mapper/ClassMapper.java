package edu.icet.mapper;

import edu.icet.dto.ClassesDto;
import edu.icet.entity.Classes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClassMapper {
    @Mapping(source = "gradeId",target = "grade.id")
    Classes toEntity(ClassesDto classesDto);
    @Mapping(source = "grade.id",target = "gradeId")
    ClassesDto toDto(Classes classes);
    @Mapping(source = "gradeId",target = "grade.id")
    List<ClassesDto> toDtoList(List<Classes> classes);
}
