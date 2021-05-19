package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.entities.concretes.Candidate;

public interface CandidateService {
	List<Candidate> getAll();
}
