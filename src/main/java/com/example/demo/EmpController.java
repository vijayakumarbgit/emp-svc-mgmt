package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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

	static {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("keerthana");
		emp.setDept("EC");
		emp.setEmail("abcd@gmail.com");
		emp.setGender("F");

		Employee emp2 = new Employee();
		emp2.setId(101);
		emp2.setName("Srusti");
		emp2.setDept("CS");
		emp2.setEmail("abcde@gmail.com");
		emp2.setGender("F");
		Employee emp3 = new Employee();
		emp3.setId(102);
		emp3.setName("Sowndarya");
		emp3.setDept("Cs");
		emp3.setEmail("abcdef@gmail.com");
		emp3.setGender("F");
		Employee emp4 = new Employee();
		emp4.setId(103);
		emp4.setName("Nithin");
		emp4.setDept("EC");
		emp4.setEmail("abcd@gmail.com");
		emp4.setGender("M");

		Employee emp5 = new Employee();
		emp5.setId(104);
		emp5.setName("Vijay");
		emp5.setDept("CS");
		emp5.setEmail("abcd@gmail.com");
		emp5.setGender("M");

		list.add(emp);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);

	}

	@GetMapping("")
	public List<Employee> getEmps() {

		return list;
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
	public String AddEmp(@RequestBody Employee e) {
		list.add(e);
		// employeeRepository.save(e);
		return "Looks employee addedd successfully please check by retrieving with emp id";

	}

	@DeleteMapping("/{id}")
	public String DelEmp(@PathVariable int id) {

		/*
		 * for (Employee e : list) { if (e.getId() == id) { list.remove(e); } }
		 */
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Employee e = (Employee) iterator.next();
			if (e.getId() == id) {
				iterator.remove();
			}
		}
		return "Employee details are deleted";

	}

	@PutMapping("")
	public String UpdateEmp(@RequestBody Employee e) {
		Iterator iterator = list.iterator();

		while (iterator.hasNext()) {
			Employee e1 = (Employee) iterator.next();
			if (e1.getId() == e.getId()) {
				e1.setId(e.getId());
				e1.setName(e.getName());
				e1.setDept(e.getDept());
				e1.setEmail(e.getEmail());
				e1.setGender(e.getGender());
			}
		}

		return "Update is completed";

	}

	@RequestMapping(value = "employee", method = RequestMethod.GET)
	public List<Employee> getEmployees() {

		list.addAll(impl.getEmployees());
		return list;
	}

	@PostMapping("employee")
	public Employee AddEmployee(@RequestBody Employee e) {

		return impl.AddEmp(e);

	}

}
