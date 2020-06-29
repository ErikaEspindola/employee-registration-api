package com.employee.registration.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.employee.registration.api.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

}
