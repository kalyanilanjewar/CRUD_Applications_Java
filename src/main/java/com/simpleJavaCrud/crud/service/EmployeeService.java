package com.simpleJavaCrud.crud.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleJavaCrud.crud.dto.EmployeeDto;
import com.simpleJavaCrud.crud.model.Employee;
import com.simpleJavaCrud.crud.repository.EmployeeRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j //Lombok annotation to generate logger in the class
@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository; //This will autowire the employee repository to the service class so that we can use the repository methods in the service class to interact with the database 
	
	//Method to create an employee
	public String createEmployee(EmployeeDto employeeDto) 
	{
		try 
		{
			//Creating an employee object from the employeeDto
			Employee employee = Employee.builder()
					            .empName(employeeDto.getEmpName())
					            .salary(employeeDto.getSalary())
					            .location(employeeDto.getLocation())
					            .build();
			
			//Setting the created date to the current date and time
			employee.setCreatedDate(LocalDateTime.now());
			
			//This will save the employee object in the database
			employeeRepository.save(employee); 
		}
		catch(Exception e) 
		{
			return "Failed to create employee";
		}
		
		log.info("Employee created successfully");
		return "Employee created successfully";
	}
	
	//Method to get all employees
	public List<Employee> getEmployee(){
		//Creating an empty list of employees to store the employees retrieved from the database
		List<Employee> employeeList = new ArrayList<>();
		try {
			//This will return all the employees from the database in the form of a list
			employeeList = employeeRepository.findAll();
		}catch(Exception e) {
			
		}
		
		log.info("Employee retrieved successfully");
		return employeeList; //Returning the list of employees retrieved from the database
	}
	
	//Method to get employee by id
	public String deleteEmployee(String id) {
		try {
			//This will delete the employee from the database with the given id
			employeeRepository.deleteById(id);
		}catch(Exception e) {
			return "Failed to delete employee";
		}
		
		log.info("Employee deleted successfully");
		return "Employee deleted successfully";
	}


	//Method to update employee details by id
	public String updateEmployee(EmployeeDto employeeDto) {
		try {
			Employee employee = Employee.builder()
					           .id(employeeDto.getId() != null ? employeeDto.getId() : null)
					           .empName(employeeDto.getEmpName() != null ? employeeDto.getEmpName() : null)
					           .location(employeeDto.getLocation() != null ? employeeDto.getLocation() : null)
					           .salary(employeeDto.getSalary() != null ? employeeDto.getSalary() : null)
					           .build();
			
			//Setting the modified date to the current date and time
			employee.setModifiedDate(LocalDateTime.now());
			
			//This will update the employee in the database with the new values
			employeeRepository.save(employee);
		}catch(Exception e) {
			return "Failed to update employee";
		}
		
		log.info("Employee updated successfully");
		return "Employee updated successfully";
	}

}
