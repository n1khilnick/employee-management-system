package com.geekster.employeemanagementsystem.services;

import com.geekster.employeemanagementsystem.dto.SignInInput;
import com.geekster.employeemanagementsystem.dto.SignInOutput;
import com.geekster.employeemanagementsystem.dto.SignUpOutput;
import com.geekster.employeemanagementsystem.models.AuthenticationToken;
import com.geekster.employeemanagementsystem.models.Employee;
import com.geekster.employeemanagementsystem.repositories.IEmployeeDao;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeDao employeeDao;

    @Autowired
    TokenService tokenService;

    public SignUpOutput signUp(Employee signUpDto) {


        //check if user exists or not based on email
        Employee employee = employeeDao.findFirstByEmployeeEmailId(signUpDto.getEmployeeEmailId());

        if(employee != null)
        {
            throw new IllegalStateException("Employee already exists!!!!...sign in instead");
        }

//      encryption
        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signUpDto.getEmployeePassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        signUpDto.setEmployeePassword(encryptedPassword);
        employeeDao.save(signUpDto);

        return new SignUpOutput("Employee registered","Employee account created successfully");

    }

    private String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;

    }

    public SignInOutput signIn(SignInInput signInDto) {
        //check if user exists or not based on email
        Employee user = employeeDao.findFirstByEmployeeEmailId(signInDto.getEmployeeEmailId());

        if(user == null)
        {
            throw new IllegalStateException("Employee invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInDto.getEmployeePassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getEmployeePassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("Employee invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }

//    public void addEmployee(Employee employee) {
//        employeeDao.save(employee);
//    }

    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    public ResponseEntity<String> updateEmployee(Long employeeId, Employee employee) {
        employee.setEmployeeSalary((double) -1);
        employee.setEmployeeJobRole("");
        if(employeeDao.findById(employeeId).isEmpty()){
            return new ResponseEntity<>("Employee with id "+employeeId+" doesn't exists !!", HttpStatus.NOT_FOUND);
        }
        Employee employeeDetails = employeeDao.findById(employeeId).get();

        if(employee.getEmployeeFirstName() != null){
            employeeDetails.setEmployeeFirstName(employee.getEmployeeFirstName());
        }

        if(employee.getEmployeeLastName() != null){
            employeeDetails.setEmployeeLastName(employee.getEmployeeLastName());
        }

        if(employee.getEmployeeEmailId() != null){
            employeeDetails.setEmployeeEmailId(employee.getEmployeeEmailId());
        }

        if(employee.getEmployeeContactNo() != null){
            employeeDetails.setEmployeeContactNo(employee.getEmployeeContactNo());
        }

        employeeDao.save(employeeDetails);

        return new ResponseEntity<>("Employee updated successfully !!", HttpStatus.OK);
    }

}
