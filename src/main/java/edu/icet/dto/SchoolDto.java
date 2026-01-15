package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SchoolDto {
    private Integer id;
    private String name;
    private Integer addressId;
    private Integer cityId;
    private Integer provinceId;
}
