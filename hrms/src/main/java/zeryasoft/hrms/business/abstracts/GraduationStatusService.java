package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.GraduationStatus;

public interface GraduationStatusService {
	DataResult<List<GraduationStatus>> getAll();
	Result add(GraduationStatus graduationStatus);
}
