package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.Candidate;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> add(Candidate candidate);
}
