package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.JobTitleService;
import zeryasoft.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobtitles")
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
}
