package zeryasoft.hrms.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.JobPostingFormService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.JobPostingForm;

@RestController
@RequestMapping("/api/jobpostingforms")
public class JobPostingFormController {
	
	@Autowired
	JobPostingFormService jobPostingFormService;
	
	public JobPostingFormController(JobPostingFormService jobPostingFormService) {
		super();
		this.jobPostingFormService=jobPostingFormService;
	}

	@PostMapping(name="/add")
	public DataResult<JobPostingForm> add(@RequestBody JobPostingForm jobPostingForm){
		return this.jobPostingFormService.add(jobPostingForm);
	}
}
