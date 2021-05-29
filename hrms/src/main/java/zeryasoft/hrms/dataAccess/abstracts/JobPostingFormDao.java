package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zeryasoft.hrms.entities.concretes.JobPostingForm;

public interface JobPostingFormDao extends JpaRepository<JobPostingForm, Integer>{
	@Query("From JobPostingForm where isActivated=:isActivated")
	List<JobPostingForm> getByIsActivated(@Param("isActivated") boolean isActivated);
	
	@Query("From JobPostingForm where isActivated=:isActivated and employer_id=:employerId")
	List<JobPostingForm> getActivatedPostingByCompanyName(@Param("isActivated") boolean isActivated, @Param("employerId") int employerId);
}
