package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TimetableDto {
    private Integer id;
    private Integer classId;
    private Integer subjectId;
    private Integer teacherId;
    private String dayOfWeek;
    private Integer periods;
    private String startTime;
    private String endTime;
    private Boolean isActive;
}
