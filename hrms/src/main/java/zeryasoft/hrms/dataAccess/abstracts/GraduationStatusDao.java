package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.GraduationStatus;

public interface GraduationStatusDao extends JpaRepository<GraduationStatus, Integer>{
	boolean existsByGraduation(String graduation);
}
