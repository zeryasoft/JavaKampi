package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.EmployerService;
import zeryasoft.hrms.dataAccess.abstracts.EmployerDao;
import zeryasoft.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;

	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao=employerDao;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

}
