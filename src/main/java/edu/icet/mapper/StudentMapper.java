package edu.icet.mapper;

import edu.icet.dto.StudentDto;
import edu.icet.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(source = "classId",target = "classes.id")
    @Mapping(source = "schoolId",target = "school.id")
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDtos(List<Student> students);
    StudentDto toDto(Student student);
}
