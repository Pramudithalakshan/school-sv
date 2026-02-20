package edu.icet.mapper;

import edu.icet.dto.TeacherDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherRowMapper implements RowMapper<TeacherDto> {
    @Override
    public TeacherDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        TeacherDto teacher = new TeacherDto();
        teacher.setId(rs.getInt("id"));
        teacher.setFirstName(rs.getString("firstName"));
        teacher.setLastName(rs.getString("lastName"));
        teacher.setGender(rs.getString("gender"));
        teacher.setContact(rs.getString("contact"));
        teacher.setEmail(rs.getString("email"));
        teacher.setQualification(rs.getString("qualification"));
        teacher.setHireDate(rs.getDate("hireDate"));
        teacher.setIsActive(rs.getBoolean("isActive"));
        teacher.setMediumId(rs.getInt("mediumId"));
        teacher.setSubjectId(rs.getInt("subjectId"));
        teacher.setEmployeeId(rs.getInt("employeeId"));
        return teacher;
    }
}
