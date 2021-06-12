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

import zeryasoft.hrms.business.abstracts.JobPostingService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.JobPosting;
import zeryasoft.hrms.entities.dtos.JobPostingAddDto;
import zeryasoft.hrms.entities.dtos.JobPostingDto;

@RestController
@RequestMapping("/api/jobpostingforms")
@CrossOrigin
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingFormService) {
		super();
		this.jobPostingService = jobPostingFormService;
	}

	@PostMapping(name = "/add")
	public DataResult<JobPosting> add(@RequestBody JobPosting jobPostingForm) {
		return this.jobPostingService.add(jobPostingForm);
	}
	@PostMapping("/addDto")
	public Result add(@Valid @RequestBody JobPostingAddDto jobPostingAddDto) {
		return this.jobPostingService.addDto(jobPostingAddDto);
	}
	
	//Aktif Pasif Tüm iş ilanlarını getirir
	@GetMapping("/getAllJobPosting")
	public DataResult<List<JobPosting>> getAllJobPosting() {
		return this.jobPostingService.getAllJobPosting();
	}


	// Tüm Aktif iş ilanları 1 with Dto
	@GetMapping("/getActiveEmployer")
	DataResult<List<JobPostingDto>> findByIsActivatedEmployer(){
		return this.jobPostingService.findByIsActivated(true);
	}
	
	// Tüm Aktif iş ilanları 2
	@GetMapping("/getAllActivedJobPosting")
	public DataResult<List<JobPosting>> getAllActivatedJobPosting() {
		return this.jobPostingService.getAllActivatedJobPosting();
	}
	
	//Employer Idsine göre Actif ilanlar
	@GetMapping("/getByActivatedEmployerId")
	public DataResult<List<JobPosting>> getByActivatedEmployedId(int employer_id) {
		return this.jobPostingService.getByActivatedEmployerId(employer_id);
	}

	
	// ilan tarihine göre aktif iş ilanları

	@GetMapping("/getJobPostingByIsActivatedTrueAndOrderByDate")
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return this.jobPostingService.findByIsActiveOrderByClosedDate();
	}

	@PostMapping(path = "/updateEmployerJobPostingToPassive")
	public DataResult<List<JobPosting>> updateJobPostingToPassive(int jobPostingFormId) {
		return this.jobPostingService.updateJobPostingIsActivatedForEmployerId(jobPostingFormId);
	}
	
	
	/*
	 * @GetMapping("/getByCompanyName") DataResult<List<JobPostingDto>>
	 * findByIsActiveAndEmployer_CompanyName(String companyName){ return
	 * this.jobPostingService.getByCompanyNameAndIsActivatedTrue(companyName);
	 * 
	 * }
	 */
}
