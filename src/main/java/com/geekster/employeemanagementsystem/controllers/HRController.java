package com.geekster.employeemanagementsystem.controllers;

import com.geekster.employeemanagementsystem.models.Employee;
import com.geekster.employeemanagementsystem.models.HR;
import com.geekster.employeemanagementsystem.services.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/hr")
public class HRController {

    @Autowired
    HRService hrService;


    @PostMapping(value = "/")
    public ResponseEntity<String> addRest(@RequestBody HR hr){

        return new ResponseEntity<String>("HR Successfully Added !!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/employeeId/employee")
    public ResponseEntity<String>updateEmployeeDetails(@PathVariable int employeeId, @RequestBody Employee employee){
        return hrService.updateEmployeeDetails(employeeId,employee);
    }
}
