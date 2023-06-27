package com.geekster.employeemanagementsystem.repositories;

import com.geekster.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeDao extends JpaRepository<Employee,Long>  {

    Employee findFirstByEmployeeEmailId(String employeeEmailId);
}
