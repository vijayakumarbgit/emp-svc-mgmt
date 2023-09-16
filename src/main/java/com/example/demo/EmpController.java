package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emp.service.EmployeeService;
import com.models.Employee;

@RestController
@RequestMapping(value = "/emp/")
@CrossOrigin
public class EmpController {

	@Autowired
	private EmployeeService impl;

	/*
	 * @Autowired private EmployeeRepository employeeRepository;
	 */
	static List<Employee> list = new ArrayList<Employee>();

	@GetMapping("")
	public List<Employee> getEmps() {

		return impl.getEmployees();
	}

	@GetMapping("/{id}")
	public Employee getEmp(@PathVariable int id) {

		for (Employee e : list) {
			if (e.getId() == id) {
				return e;
			}
		}
		return null;
	}

	@PostMapping("")
	public Employee AddEmp(@RequestBody Employee e) {
		list.add(e);
		return impl.addEmp(e);

	}

	@DeleteMapping("/{id}")
	public void DelEmp(@PathVariable int id) {
		impl.delEmp(id);
	}

	@PutMapping("")
	public Employee UpdateEmp(@RequestBody Employee e) {

		return impl.updateEmp(e);

	}

	// ########Test code is below#########################

	@RequestMapping(value = "employee", method = RequestMethod.GET)
	public List<Employee> getEmployees() {

		list.addAll(impl.getEmployees());
		return list;
	}

	@PostMapping("employee")
	public Employee AddEmployee(@RequestBody Employee e) {

		return impl.addEmp(e);

	}

	/*
	 * static { Employee emp = new Employee(); emp.setId(100);
	 * emp.setName("keerthana"); emp.setDept("EC"); emp.setEmail("abcd@gmail.com");
	 * emp.setGender("F");
	 * 
	 * Employee emp2 = new Employee(); emp2.setId(101); emp2.setName("Srusti");
	 * emp2.setDept("CS"); emp2.setEmail("abcde@gmail.com"); emp2.setGender("F");
	 * Employee emp3 = new Employee(); emp3.setId(102); emp3.setName("Sowndarya");
	 * emp3.setDept("Cs"); emp3.setEmail("abcdef@gmail.com"); emp3.setGender("F");
	 * Employee emp4 = new Employee(); emp4.setId(103); emp4.setName("Nithin");
	 * emp4.setDept("EC"); emp4.setEmail("abcd@gmail.com"); emp4.setGender("M");
	 * 
	 * Employee emp5 = new Employee(); emp5.setId(104); emp5.setName("Vijay");
	 * emp5.setDept("CS"); emp5.setEmail("abcd@gmail.com"); emp5.setGender("M");
	 * 
	 * list.add(emp); list.add(emp2); list.add(emp3); list.add(emp4);
	 * list.add(emp5); }
	 */

}
