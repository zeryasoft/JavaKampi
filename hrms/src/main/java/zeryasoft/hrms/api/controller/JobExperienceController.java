package zeryasoft.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.JobExperienceService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("api/jobExperience")
public class JobExperienceController {

	private JobExperienceService jobExperienceService;
	
	@Autowired
	public JobExperienceController(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}


	@GetMapping("/getall")
	public DataResult<List<JobExperience>> getAll(){
		return this.jobExperienceService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	  }
	
}
