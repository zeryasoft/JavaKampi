package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.CandidateService;
import zeryasoft.hrms.dataAccess.abstracts.CandidateDao;
import zeryasoft.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao=candidateDao;
	}

	@Override
	public List<Candidate> getAll() {
		return this.candidateDao.findAll();
	}

}
