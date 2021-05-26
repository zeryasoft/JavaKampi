package zeryasoft.hrms.business.abstracts;

import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.EmailVerify;

public interface EmailVerifyService {
	
	void generateCode(EmailVerify code, Integer id);
	Result verify(String verificationCode, Integer id);
}
