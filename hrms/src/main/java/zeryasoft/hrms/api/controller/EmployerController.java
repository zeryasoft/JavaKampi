package zeryasoft.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.EmployerService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployerController {
	
	EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService=employerService;
	}
	
	@GetMapping("/getAll")
	public List<Employer> getAll() {
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<Employer> add(@Valid @RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
}
