package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "schools")
public class School {
    @Id
    private Integer id;
    private String name;
    private Integer addressId;
    private Integer cityId;
    private Integer provinceId;
    @OneToMany(mappedBy = "school",cascade = CascadeType.ALL)
    private List<Student> students;
}
