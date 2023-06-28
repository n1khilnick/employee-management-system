## Employee Management System

## Frameworks and Language Used
* Spring Boot
* Spring MVC
* Hibernate/JPA
* MySQL


## Data Flow
1. Controller
   * Employee Controller
     * **POST** /api/v1/employee/signup: Creates a new employee account.
     * **POST** /api/v1/employee/signin: Authenticates an employee and generates an access token.
     * **POST** /api/v1/employee/signout: Invalidates the access token for the employee, logging them out.
     * **GET** /api/v1/employee/: Retrieves a list of all employees.
     
2. Services
   * Employee Service: Handles business logic related to employee management.
3. Repository
   * Employee Repository: Provides CRUD operations for employee entities.
4. Database Design
    * The database design for the Employee Management System includes the following tables/entities:


## Data Structure Used
* The Employee Management System utilizes the following data structures:

## Project Summary
The Employee Management System using Spring Boot is a web-based application designed to streamline the management of employee data for an organization. It provides an easy-to-use interface for HR personnel to manage employee records, including personal information, job roles, and salary details. Employees can also view and update their own personal information through the self-service module. The system offers reporting capabilities for generating reports related to employee attendance and performance. With the integration of Spring Boot, Spring MVC, Hibernate/JPA, and MySQL, this application provides a robust and efficient solution for effective employee data management.