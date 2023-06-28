package com.geekster.employeemanagementsystem.services;

import com.geekster.employeemanagementsystem.models.Employee;
import com.geekster.employeemanagementsystem.models.HR;
import com.geekster.employeemanagementsystem.repositories.IEmployeeDao;
import com.geekster.employeemanagementsystem.repositories.IHRDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HRService {
    IHRDao hrDao;

    IEmployeeDao employeeDao;

    public ResponseEntity<String> addHR(HR hr) {
        List<HR> allHR = (List<HR>) hrDao.findAll();
        return new ResponseEntity<String>("HR already exist",HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> updateEmployeeDetails(Long hrId,Long employeeId, Employee employee) {
        if(hrDao.findById(hrId).isPresent()){
            employeeDao.save(employee);
            return new ResponseEntity<String>("Employee updated successfully",HttpStatus.CREATED);
        }
        return new ResponseEntity<String>("HR does not exist",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteEmployee(long hrId, int employeeId) {
        if(hrDao.findById(hrId).isPresent()){
            HR hr = hrDao.findById(hrId).get();
            List<Employee>allEmployee = hr.getListEmployee();
            Employee employee = allEmployee.get(employeeId);
            if(employee!=null){
                employeeDao.delete(employee);
                return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("HR does not exist",HttpStatus.BAD_REQUEST);
    }
}
