package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
	DataResult<JobTitle> add(JobTitle jobTitle);
}
