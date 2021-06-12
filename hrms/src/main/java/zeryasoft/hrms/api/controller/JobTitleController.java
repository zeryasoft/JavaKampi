package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.JobTitleService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
@CrossOrigin
public class JobTitleController {
	
	@Autowired
	private JobTitleService jobTitleService;

	public JobTitleController(JobTitleService jobTitleService) {
		super();
		this.jobTitleService=jobTitleService;
	}
	
	@GetMapping("/getAll")
	public List<JobTitle> getAll() {
		return jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	public DataResult<JobTitle> add(@RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}
}
