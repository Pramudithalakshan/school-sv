package edu.icet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Builder
@Table(name = "users")
public class User {
    @Id
    private Integer id;
    @NotBlank(message = "Username can't be empty.")
    private String username;
    @NotBlank(message = "Password can't be empty")
    private String password;
    @NotBlank(message = "Role can't be empty")
    private String role;
}
