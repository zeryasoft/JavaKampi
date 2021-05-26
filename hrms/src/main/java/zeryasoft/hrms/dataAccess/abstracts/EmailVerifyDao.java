package zeryasoft.hrms.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.EmailVerify;

public interface EmailVerifyDao extends JpaRepository<EmailVerify, Integer> {

	Optional<EmailVerify> findById(Integer id);

}
