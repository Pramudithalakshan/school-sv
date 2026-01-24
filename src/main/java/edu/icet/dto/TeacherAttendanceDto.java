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
public class TeacherAttendanceDto {private Integer id;
    private Integer teacherId;
    private Date date;
    private String checkInTime;
    private String checkOutTime;
}
