package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Attendance {
    private Integer id;
    private Integer studentId;
    private Integer classId;
    private Date enrollDate;
    private enum Status {
        PRESENT,
        ABSENT
    }
    private Status status;

}
