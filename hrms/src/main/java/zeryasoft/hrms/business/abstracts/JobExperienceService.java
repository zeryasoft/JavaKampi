package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {
	Result add(JobExperience jobExpeerience);
	DataResult<List<JobExperience>> getAll();
}
