package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String contact;
    private String email;
    private String qualification;
    private Date hireDate;
    private Boolean isActive;
    private Integer mediumId;
    private Integer subjectId;
    private Integer employeeId;
}
