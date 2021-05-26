package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.JobTitleService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.ErrorDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.JobTitleDao;
import zeryasoft.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{

	private JobTitleDao jobTitleDao;
	
	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao=jobTitleDao;
	}	
	
	@Override
	public List<JobTitle> getAll() {
		return this.jobTitleDao.findAll();
	}

	@Override
	public DataResult<JobTitle> add(JobTitle jobTitle) {
		if(this.jobTitleDao.findAllByTitle(jobTitle.getTitle()).stream().count()!=0) {
			return new ErrorDataResult<JobTitle>(jobTitle,"This Title is Exist");
		}
		
		return new SuccessDataResult<JobTitle>(this.jobTitleDao.save(jobTitle),"Job Title Added Successfully");
	}

}
