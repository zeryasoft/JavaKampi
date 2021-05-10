package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
