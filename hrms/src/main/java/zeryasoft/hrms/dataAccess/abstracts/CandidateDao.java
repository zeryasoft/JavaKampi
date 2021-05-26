package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	List<Candidate> findAllByIdentityNumber(String identityNumber);

	List<Candidate> findAllByEmail(String email);

}
