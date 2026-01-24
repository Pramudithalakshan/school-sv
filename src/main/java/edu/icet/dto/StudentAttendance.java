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
public class    StudentAttendance {
    private Integer id;
    private Integer studentId;
    private Date date;
    private Boolean isAttended;
}
