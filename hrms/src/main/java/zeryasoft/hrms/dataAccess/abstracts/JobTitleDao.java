package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import zeryasoft.hrms.entities.concretes.JobTitle;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {

	@Query("select u from JobTitle u where lower(u.title) like lower(concat('%', :title, '%'))")
	List<JobTitle> findJobTitles(@Param("title") String title);

	List<JobTitle> findAllByTitle(String title);
}
