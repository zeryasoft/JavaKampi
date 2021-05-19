package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.EmployeeService;
import zeryasoft.hrms.entities.concretes.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return this.employeeService.getAll();
	}
}
