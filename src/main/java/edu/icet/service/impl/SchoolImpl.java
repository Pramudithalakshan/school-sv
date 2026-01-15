package edu.icet.service.impl;

import edu.icet.dto.SchoolDto;
import edu.icet.entity.School;
import edu.icet.mapper.SchoolMapper;
import edu.icet.repository.SchoolRepository;
import edu.icet.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolImpl implements SchoolService {
    private final SchoolRepository repository;
    private final ModelMapper modelMapper;
    private final SchoolMapper schoolMapper;
    @Override
    public void addSchool(SchoolDto schoolDto) {
        repository.save(modelMapper.map(schoolDto,School.class));
    }

    @Override
    public List<SchoolDto> getSchool() {
        return schoolMapper.toDtos(repository.findAll());
    }

    @Override
    public void deleteSchool(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public SchoolDto searchSchool(Integer id) {
       return repository.findById(id)
               .map(schoolMapper::toDto)
               .orElseThrow(() -> new RuntimeException(""));
    }
}
