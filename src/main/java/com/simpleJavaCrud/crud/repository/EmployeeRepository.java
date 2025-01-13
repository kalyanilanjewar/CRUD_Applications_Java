package com.simpleJavaCrud.crud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.simpleJavaCrud.crud.model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
