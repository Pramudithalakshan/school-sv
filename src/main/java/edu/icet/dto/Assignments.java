package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Assignments {
    private Integer id;
    private String name;
    private Integer courseId;
    private Date dueDate;
}
