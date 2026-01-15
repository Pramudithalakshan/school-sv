package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.mapper.StudentMapper;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class StudentImpl implements StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;
    @Override
    public void addStudent(StudentDto student) {
        repository.save(studentMapper.toEntity(student));
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
    public Optional<StudentDto> searchStudent(Integer id) {
        return studentMapper.toDto(repository.findById(id));
    }
}
