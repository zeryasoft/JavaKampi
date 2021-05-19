package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.JobTitleService;
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

}
