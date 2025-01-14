package com.simpleJavaCrud.crud.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Builder;
import lombok.Data;

@Document(value = "EMPLOYEE")
@Data
@Builder
public class Employee {
	
	@Id
	private String id;
	
	@Field(name = "EMPLOYEE_NAME")
	private String empName;
	
	@Field(name = "LOCATION")
	private String location;
	
	@Field(name = "SALARY")
	private BigDecimal salary;
}
