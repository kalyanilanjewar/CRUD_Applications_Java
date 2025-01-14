package com.simpleJavaCrud.crud.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor //Lombok annotation to generate no-args constructor
@AllArgsConstructor // Lombok annotation to generate all-args constructor
public class EmployeeDto {
	
	private String id;
	private String empName;
	private String location;
	private BigDecimal salary;

}
