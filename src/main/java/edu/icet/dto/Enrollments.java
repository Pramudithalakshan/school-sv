package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Enrollments {
    private Integer id;
    private  Integer studentId;
    private Integer courseId;
    private Date enrollDate;
}
