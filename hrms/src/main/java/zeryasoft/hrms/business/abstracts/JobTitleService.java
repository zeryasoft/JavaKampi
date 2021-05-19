package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	List<JobTitle> getAll();
}
