package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentImpl implements StudentService {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public void addStudent(StudentDto dto) {
        String sql = "INSERT INTO students(id,class_id,first_name,last_name,date_of_birth,gender" +
                ",address,phone_number,email,enrollment_date,school_id,hostel_id) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                dto.getId(),
                dto.getClassId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getDateOfBirth(),
                dto.getGender(),
                dto.getAddress(),
                dto.getContact(),
                dto.getEmail(),
                dto.getEnrollmentDate(),
                dto.getSchoolId(),
                dto.getHostelId()
                );
    }

    @Override
    public List<StudentDto> getStudent() {
        String sql = "SELECT classes.class_name,first_name,last_name,date_of_birth,gender,address,phone_number,email," +
                "enrollment_date,schools.school_name,hostels.hostel_name " +
                "FROM students INNER JOIN classes ON students.class_id = classes.id INNER JOIN schools ON students.school_id = schools.id " +
                "INNER JOIN hostels ON students.hostel_id = hostels.id";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(StudentDto.class));
    }

    @Override
    public void deleteStudent(Integer id) {
        String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public StudentDto searchStudent(Integer id) {
        String sql = "SELECT * FROM students WHERE id=?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(StudentDto.class),id);
    }
}
