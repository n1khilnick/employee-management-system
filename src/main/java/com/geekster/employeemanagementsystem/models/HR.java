package com.geekster.employeemanagementsystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hrId;

    @Column(nullable = false)
    @NotEmpty
    private String hrFirstName;

    @Column(nullable = false)
    @NotEmpty
    private String hrLastName;

    @Column(unique = true , nullable = false)
    @Email(message = "Please provide valid email !")
    @NotBlank
    private String hrEmailId;

}
