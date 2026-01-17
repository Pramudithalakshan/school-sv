package edu.icet.service.impl;

import edu.icet.dto.ClassesDto;
import edu.icet.entity.Classes;
import edu.icet.mapper.ClassMapper;
import edu.icet.repository.ClassesRepository;
import edu.icet.service.ClassesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClassesImpl implements ClassesService {
    private final ClassesRepository repository;
    private final ClassMapper classMapper;
    @Override
    public void addClass(ClassesDto classesDto) {
       repository.save(classMapper.toEntity(classesDto));
    }

    @Override
    public List<ClassesDto> getClasses() {
        return classMapper.toDtoList(repository.findAll());
    }

    @Override
    public ClassesDto searchClass(Integer id) {
        Classes classes = repository.findById(id).orElseThrow(() ->new RuntimeException("class not found"));
        return classMapper.toDto(classes);
    }

    @Override
    public void deleteClass(Integer id) {
        repository.deleteById(id);
    }
}
