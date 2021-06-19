package zeryasoft.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import zeryasoft.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	List<User> getById(@Param("id") int id);
	List<User> findAllByEmail(String email);

}
