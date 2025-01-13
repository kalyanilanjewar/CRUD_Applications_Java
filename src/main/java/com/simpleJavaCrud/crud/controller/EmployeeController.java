package com.simpleJavaCrud.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.simpleJavaCrud.crud.dto.EmployeeDto;
import com.simpleJavaCrud.crud.model.Employee;
import com.simpleJavaCrud.crud.service.EmployeeService;

@RestController
@RequestMapping("api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED) // HttpStatus.CREATED will actually send 201 status code when you hit this API
	public String createEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.createEmployee(employeeDto); //This will return the response from the service method (createEmployee)
	}
	
	@GetMapping("/get/employee")
	@ResponseStatus(HttpStatus.OK)//HttpStatus.OK will actually send 200 status code when you hit this API 
	public List<Employee> getEmployee(){
		return employeeService.getEmployee(); //This will return the response from the service method (getEmployee)
	}
	
	@GetMapping("/delete/employee")
	@ResponseStatus(HttpStatus.OK) //HttpStatus.OK will actually send 200 status code when you hit this API 
	public String deleteEmployee(@RequestParam String id) {
		return employeeService.deleteEmployee(id); //This will return response from the service method (seleteEmployee)
	}
	
	@PutMapping("update/employee")
	@ResponseStatus(HttpStatus.CREATED) //HttpStatus.CREATED will actually send 201 status code when you will hit this API
	public String updateEmployee(@RequestBody EmployeeDto employeeDto) {
		return employeeService.updateEmployee(employeeDto); //This will return respinse from the service method (updateEmployee))
	}

}
