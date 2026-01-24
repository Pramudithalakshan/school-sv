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
public class LeaveDto {
    private Integer id;
    private Integer teacherId;
    private Date date;
    private String reason;
    private Boolean isApproved;
}
