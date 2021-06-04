package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	
	Result add(ProgrammingLanguage programmingLanguage);
	
	DataResult<List<ProgrammingLanguage>> getAll();
}
