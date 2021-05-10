package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.JobPositionService;
import zeryasoft.hrms.dataAccess.abstracts.JobPositionDao;
import zeryasoft.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao=jobPositionDao;
	}
	
	
	@Override
	public List<JobPosition> getAll() {
		return this.jobPositionDao.findAll();
	}

}
