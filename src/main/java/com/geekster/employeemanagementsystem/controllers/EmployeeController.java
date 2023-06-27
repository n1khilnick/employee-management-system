package com.geekster.employeemanagementsystem.controllers;

import com.geekster.employeemanagementsystem.dto.SignInInput;
import com.geekster.employeemanagementsystem.dto.SignInOutput;
import com.geekster.employeemanagementsystem.dto.SignUpOutput;
import com.geekster.employeemanagementsystem.models.Employee;
import com.geekster.employeemanagementsystem.services.EmployeeService;
import com.geekster.employeemanagementsystem.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    TokenService authService;

//
//    @PostMapping(value = "/signup")
//    public ResponseEntity<String> addRest(@RequestBody Employee employee){
//        employee.setEmployeeSalary((double) -1);
//        employee.setEmployeeJobRole("");
//        employeeService.addEmployee(employee);
//        return new ResponseEntity<String>("Employee Successfully Created !!",HttpStatus.CREATED);
//    }

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody Employee signUpDto){
        signUpDto.setEmployeeSalary((double) -1);
        signUpDto.setEmployeeJobRole("");
        return employeeService.signUp(signUpDto);
    }


    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto){

        return employeeService.signIn(signInDto);
    }


    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String employeeEmailId , @RequestParam String token){
        HttpStatus status;
        String msg=null;

        if(authService.authenticate(employeeEmailId,token))
        {
            authService.deleteToken(token);
            msg = "Sign-out Successful";
            status = HttpStatus.OK;

        }
        else
        {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg , status);
    }

    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId,employee);
    }
}
