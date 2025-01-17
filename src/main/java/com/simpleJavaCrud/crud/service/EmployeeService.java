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
	private EmployeeRepository employeeRepository;
	
	//Method to create an employee
	public String createEmployee(EmployeeDto employeeDto) 
	{
		try 
		{
			//Creating an employee object from the employeeDto
			Employee employee = Employee.builder()
//					            .createdDate(employeeDto.getCreatedDate())
					            .empName(employeeDto.getEmpName())
					            .salary(employeeDto.getSalary())
					            .location(employeeDto.getLocation())
					            .build();
			employee.setCreatedDate(LocalDateTime.now());
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
		List<Employee> employeeList = new ArrayList<>();
		try {
			employeeList = employeeRepository.findAll();
		}catch(Exception e) {
			
		}
		
		log.info("Employee retrieved successfully");
		return employeeList;
	}
	
	//Method to get employee by id
	public String deleteEmployee(String id) {
		try {
			employeeRepository.deleteById(id);
		}catch(Exception e) {
			return "Failed to delete employee";
		}
		
		log.info("Employee deleted successfully");
		return "Employee deleted successfully";
	}


	public String updateEmployee(EmployeeDto employeeDto) {
		try {
			Employee employee = Employee.builder()
					           .id(employeeDto.getId())
					           .empName(employeeDto.getEmpName())
					           .location(employeeDto.getLocation())
					           .salary(employeeDto.getSalary())
					           .build();
			employee.setModifiedDate(LocalDateTime.now());
			employeeRepository.save(employee);//This will update the employee in the database with the new values
		}catch(Exception e) {
			return "Failed to update employee";
		}
		
		log.info("Employee updated successfully");
		return "Employee updated successfully";
	}

}
