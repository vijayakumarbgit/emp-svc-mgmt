package com.emp.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.service.EmployeeService;
import com.models.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmp(Employee e) {

		return employeeRepository.save(e);
	}

	@Override
	public void delEmp(int id) {

		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmp(Employee e) {

		int id = e.getId();
		Optional<Employee> emp = employeeRepository.findById(id);
		if (emp.isPresent()) {
			return employeeRepository.save(e);
		}
		return null;
	}
}
