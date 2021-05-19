package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer>{

}
