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
public class AcademicYearDto {
    private Integer id;
    private Date startDate;
    private Date endDate;
    private Boolean isActive;
}
