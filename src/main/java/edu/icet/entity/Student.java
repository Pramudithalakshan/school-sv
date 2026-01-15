package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "students")
public class Student {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Integer genderId;
    private Integer cityId;
    private Integer addressId;
}
