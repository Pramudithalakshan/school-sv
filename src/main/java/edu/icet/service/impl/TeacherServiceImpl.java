package edu.icet.service.impl;

import edu.icet.dto.TeacherDto;
import edu.icet.exception.ResourceNotFoundException;
import edu.icet.mapper.TeacherRowMapper;
import edu.icet.service.TeacherService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final JdbcClient jdbcClient;
    @Override
    public void add(TeacherDto teacher) {
        jdbcClient.sql("INSERT INTO teachers (first_name, last_name, gender, contact_number, email, qualification, " +
                "hire_date, isActive, medium_id, subject_id, employee_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")
                .params(teacher.getId(),teacher.getFirstName(), teacher.getLastName(),teacher.getGender(),teacher.getContact(), teacher.getEmail(),
                        teacher.getQualification(),teacher.getHireDate(),teacher.getIsActive(),teacher.getMediumId(),teacher.getSubjectId(),
                        teacher.getEmployeeId())
                .update();
    }

    @Override
    public Page<@NotNull TeacherDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public TeacherDto getTeacher(Integer id) {
        try {
            return jdbcClient.sql("SELECT * FROM teachers WHERE id = ?")
                    .param(id)
                    .query(new TeacherRowMapper())
                    .single();
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("No teacher with id " + id);
        }
    }

    @Override
    public void delete(Integer id) {
        int rowAffected = jdbcClient.sql("DELETE FROM teachers WHERE id= :id")
                .param("id",id)
                .update();
        if(rowAffected==0){
            throw new ResourceNotFoundException("No teacher with id " + id);
        }
    }

    @Override
    public TeacherDto update(TeacherDto dto, Integer id) {
        return null;
    }
}
