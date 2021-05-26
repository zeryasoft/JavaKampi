package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
	DataResult<Employer> add(Employer employer);
}
