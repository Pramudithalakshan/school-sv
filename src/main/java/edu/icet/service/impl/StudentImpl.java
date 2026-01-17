package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.mapper.StudentMapper;
import edu.icet.repository.SchoolRepository;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;
    private final ModelMapper modelMapper;
    private final SchoolRepository schoolRepository;
    @Override
    public void addStudent(StudentDto studentDto) {
        repository.save(studentMapper.toEntity(studentDto));
    }

    @Override
    public List<StudentDto> getStudent() {
        return studentMapper.toDtos(repository.findAll());
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto searchStudent(Integer id) {
        return repository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(()->new RuntimeException("Student not found"));
    }
}
