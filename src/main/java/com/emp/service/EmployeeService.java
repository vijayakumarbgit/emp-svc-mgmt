package com.emp.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.models.Employee;

@Component
public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee AddEmp(Employee e);

}
