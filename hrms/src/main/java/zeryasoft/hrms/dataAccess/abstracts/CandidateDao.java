package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{

}
