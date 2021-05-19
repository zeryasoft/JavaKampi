package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.EmployerService;
import zeryasoft.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	
	@Autowired
	EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		super();
		this.employerService=employerService;
	}
	
	@GetMapping("/getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}
}
