package zeryasoft.hrms.business.abstracts;


import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormService {
	DataResult<JobPostingForm> add(JobPostingForm jobPostingForm);
	
	DataResult<List<JobPostingForm>> getByActivatedPosting(boolean isActivated);

	DataResult<List<JobPostingForm>> ActivatedPostingByDate();

	DataResult<List<JobPostingForm>> getActivatedPostingByCompanyName(boolean isActivated, int employerId);
}
