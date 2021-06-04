package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

}
