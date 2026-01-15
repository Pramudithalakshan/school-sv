package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {
    private Integer schoolId;
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer classId;
    private String phone;
    private String email;
}
