package com.internship.users.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.YearMonth;

@Entity
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Username cannot be null")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$",
            message = "Password must contain at least one digit, one letter, and one special character (@#$%^&+=)")
    private String password;

    @Column(updatable = false)
    YearMonth dateOfEntry;

    @PrePersist
    protected void onCreate() {
        dateOfEntry = YearMonth.now(); // Set the entry date before persisting
    }
}
