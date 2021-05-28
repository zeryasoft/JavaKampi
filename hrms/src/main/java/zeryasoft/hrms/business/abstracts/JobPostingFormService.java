package zeryasoft.hrms.business.abstracts;


import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormService {
	DataResult<JobPostingForm> add(JobPostingForm jobPostingForm);
}
