package edu.icet.mapper;

import edu.icet.dto.StudentDto;
import edu.icet.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto student);
    List<StudentDto> toDtos(List<Student> students);
    StudentDto toDto(Student student);
}
