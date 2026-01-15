package edu.icet.mapper;

import edu.icet.dto.SchoolDto;
import edu.icet.entity.School;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    List<SchoolDto> toDtos(List<School> schools);
    SchoolDto toDto(School school);
}
