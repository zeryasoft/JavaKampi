package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {

	/*
	 * @Query("select u from Candidate where lower(u.identity_number) like lower(concat('%', :IdentityNumber, '%'))"
	 * ) List<Candidate> findIdentityNumbers(@Param("IdentityNumber") String
	 * IdentityNumber);
	 */

	//List<Candidate> findAllByIdentityNumber(String IdentityNumber);

	List<Candidate> findAllByEmail(String email);

}
