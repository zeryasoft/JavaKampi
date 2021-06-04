package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.ProgrammingLanguageService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import zeryasoft.hrms.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	
	private ProgrammingLanguageDao programmingLanguageDao;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
		super();
		this.programmingLanguageDao = programmingLanguageDao;
	}

	@Override
	public Result add(ProgrammingLanguage programmingLanguage) {
		programmingLanguageDao.save(programmingLanguage);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<ProgrammingLanguage>> getAll() {
		return new SuccessDataResult<List<ProgrammingLanguage>>(programmingLanguageDao.findAll(), "Başarıyla Listelendi");
	}

}
