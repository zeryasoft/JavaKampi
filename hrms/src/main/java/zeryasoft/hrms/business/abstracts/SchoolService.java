package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.dtos.SchoolDto;

public interface SchoolService{
	
	Result add(SchoolDto educationDto);	
	DataResult<List<SchoolDto>> getAll();
}
