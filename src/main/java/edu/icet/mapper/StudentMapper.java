package edu.icet.mapper;

import edu.icet.dto.StudentDto;
import edu.icet.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto student);
    List<StudentDto> toDtos(List<Student> students);
    Optional<StudentDto> toDto(Optional<Student> student);
}
