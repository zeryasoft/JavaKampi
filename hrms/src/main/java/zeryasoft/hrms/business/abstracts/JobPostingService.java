package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.JobPosting;
import zeryasoft.hrms.entities.dtos.JobPostingAddDto;
import zeryasoft.hrms.entities.dtos.JobPostingDto;

public interface JobPostingService {
	
	DataResult<JobPosting> add(JobPosting jobPosting);
	Result addDto(JobPostingAddDto jobPostingAddDto);

	DataResult<List<JobPosting>> getAllJobPosting();
	
	DataResult<List<JobPosting>> getAllActivatedJobPosting();
	DataResult<List<JobPostingDto>> findByIsActivated(boolean isActivated);
	DataResult<List<JobPosting>> getByActivatedEmployerId(int employer_id);
	
	DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate();

	DataResult<List<JobPosting>> updateJobPostingIsActivatedForEmployerId(int jobPostingFormId);
	

	//DataResult<List<JobPostingDto>> getByCompanyNameAndIsActivatedTrue(String companyName);
}
