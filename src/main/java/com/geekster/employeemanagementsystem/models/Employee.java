package com.geekster.employeemanagementsystem.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeFirstName;

    private String employeeLastName;

    @Email(message = "Please provide valid email !")
    private String employeeEmailId;

//    @Length(min = 10, max = 10, message = "Please enter correct phone number.")
//@Pattern(regexp = "^[0-9]{10}$")
    private Long employeeContactNo;

    private String employeePassword;

    private String employeeJobRole;

    private Double employeeSalary;


}
