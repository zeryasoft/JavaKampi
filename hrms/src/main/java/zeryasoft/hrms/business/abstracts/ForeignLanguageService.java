package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	Result add(ForeignLanguage language);
	DataResult<List<ForeignLanguage>> getAll();
}
