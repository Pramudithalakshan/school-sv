package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Students {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private enum gender {
        MALE,FEMALE,OTHER
    }
    private gender gender;
    private String address;
    private String phone;
    private String email;
    private Integer parentId;
    private Integer classId;
}
