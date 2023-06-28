## Employee Management System
A Java Spring Boot application for efficient employee data management, providing HR personnel an intuitive interface and empowering employees to access and update their information.


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`


## Data Flow

### 1. Models:
* It consists of **HR**, **Employee** and **AuthenticationToken** entity classes along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.
* Used **_@OneToMany_**, **_@ManyToOne_** mapping.

### 2. Controllers:
* It consists of  **HRController** ,**EmployeeController** classes in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:
<br>

>HR's API References
<br>

* Add HR:
```*.sh-session
  http://localhost:8080/api/v1/hr/
```

* Update Employee Details:
```*.sh-session
 http://localhost:8080/api/v1/hr/employeeId/employee
```
<br>

* Delete Employee:
```*.sh-session
 http://localhost:8080/hr/hrId/{hrId}/employeeId/{employeeId}
```
<br>


>Employee's API References:
<br>

* Employee signup
```*.sh-session
  http://localhost:8080/api/v1/employee/signup
```

* Employee signin:
```*.sh-session
http://localhost:8080/api/v1/employee/signin
```
* Employee sign-out:
```*.sh-session
http://localhost:8080/api/v1/employee/signout
```

* Get All Employees:
```*.sh-session
http://localhost:8080/api/v1/employee/all
```
* Update Employee:
```*.sh-session
http://localhost:8080/api/v1/employee/{employeeId}?employeeEmail={employeeEmail}&token={token}
```

### 3. Services:
* It consists of **EmployeeService** ,**HRService**, **TokenService** classes in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.

### 4. Repositories:
* It consists of **IHRDao** ,**IEmployeeDao**, **ITokenDao** interfaces that extends JpaRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** to manage the data of entity classes by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Used _**@Modifying**_ annotation wrote named parameters query using @Query annotation to insert, update, or delete an entity.

## Project Summary
* The Employee Management System using Spring Boot is a web-based application designed to streamline the management of employee data for an organization. It provides an easy-to-use interface for HR personnel to 
  manage employee records, including personal information, job roles, and salary details. 
* Employees can also view and update their own personal information through the self-service module. The system offers reporting capabilities for generating reports related to employee attendance and performance. With the integration of Spring Boot, Spring MVC, Hibernate/JPA, and MySQL, this application provides a robust and efficient solution for effective employee data management.
