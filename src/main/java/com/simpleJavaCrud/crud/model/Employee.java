package com.simpleJavaCrud.crud.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
	
	@Field(name = "CREATED_DATE")
	LocalDateTime createdDate;
	
	@Field(name = "MODIFIED_DATE")
	LocalDateTime modifiedDate;
	
	@Field(name = "EMPLOYEE_NAME")
	private String empName;
	
	@Field(name = "LOCATION")
	private String location;
	
	@Field(name = "SALARY")
	private BigDecimal salary;
}
