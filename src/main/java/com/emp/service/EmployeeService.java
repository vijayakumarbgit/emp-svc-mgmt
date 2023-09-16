package com.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.models.Employee;

@Component
public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee addEmp(Employee e);

	public void delEmp(int id);

	public Employee updateEmp(Employee e);

}
