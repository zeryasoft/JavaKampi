package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{

}
