package edu.icet.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Integer id;
    @NotBlank(message = "Class id can't be empty")
    private Integer classId;
    @NotBlank(message = "First name can't be empty")
    private String firstName;
    @NotBlank(message = "Last name can't be empty")
    private String lastName;
    @NotBlank(message = "Date of birth can't be empty")
    private Date dateOfBirth;
    @NotBlank(message = "Gender can't be empty")
    private String gender;
    @NotBlank(message = "Address can't be empty")
    private String address;
    @NotBlank(message = "Contact number can't be empty")
    private String contact;
    @NotBlank(message ="Email can't be empty")
    private String email;
    private Date enrollmentDate;
    private Integer schoolId;
    private Integer hostelId;
    private Integer clubId;
    private Integer socityId;
}
