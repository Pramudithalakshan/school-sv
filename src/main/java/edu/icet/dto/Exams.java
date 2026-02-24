package edu.icet.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Exams {
    private Integer id;
    private String name;
    private Integer courseId;
    private Integer examTypeId;
    private Date date;
}
