package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Teachers {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private enum Gender {
        MALE, FEMALE
    }
    private Gender gender;
    private String address;
    private String phone;
    private String email;
    private Integer departmentId;
    private Integer teacherTypeId;
}
