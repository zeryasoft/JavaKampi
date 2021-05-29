package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//Aktif iş ialnları
	@GetMapping("/getByActivatedPosting")
	public DataResult<List<JobPostingForm>> getByActivatedPosting(@RequestParam("isActivated") boolean isActivated){
		return this.jobPostingFormService.getByActivatedPosting(isActivated);
	}
	
	//ilan tarihine göre aktif iş ilanları
	@GetMapping("/getActivatedPostingByDate")
	public DataResult<List<JobPostingForm>> getActivatedPostingByDate(){
		return this.jobPostingFormService.ActivatedPostingByDate();
	}
	
	//firmaya ait aktif iş ilanları
	@GetMapping("/getActivatedPostingByCompanyName")
	public DataResult<List<JobPostingForm>> getActivatedPostingByCompanyName(@RequestParam("isActivated") boolean isActivated,@RequestParam("employerId") int employerId){
		return this.jobPostingFormService.getActivatedPostingByCompanyName(isActivated,employerId);
	}
}
