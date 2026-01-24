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
public class TeacherTrainingDto {
    private Integer id;
    private Integer teacherId;
    private String programName;
    private String provider;
    private Date startDate;
    private Date endDate;
    private String certification;
}
