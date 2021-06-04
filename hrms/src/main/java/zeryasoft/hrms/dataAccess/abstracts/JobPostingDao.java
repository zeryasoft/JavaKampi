package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import zeryasoft.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {


	List<JobPosting> findByIsActivated(boolean isActivated);
	
	@Query("From JobPosting where is_activated=:active")
	List<JobPosting> getActivatedJobPosting(@Param("active") boolean active);

	List<JobPosting> findByIsActivatedOrderByApplicationDeadline(boolean isActivated);
	
	List<JobPosting> getByEmployerId(@Param("employer_id") int employer_id);

	@Query("From JobPosting where is_activated=:status")
	List<JobPosting> findByIsActiveOrderByClosedDate(@Param("status") boolean status);
	
	
	@Transactional
	@Modifying
	@Query("update JobPosting j set isActivated=false where j.jobPostingId=:jobPostingId")
	List<JobPosting> updateJobPostingIsActivatedForEmployerId(@Param("jobPostingId") int jobPostingId);

	//List<JobPosting> findByEmployerCompanyNameAndIsActive(boolean isActivated, String companyName);	
}
