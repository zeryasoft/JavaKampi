package zeryasoft.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.EmailVerifyService;
import zeryasoft.hrms.core.utilities.GenerateRandomCode;
import zeryasoft.hrms.core.utilities.results.ErrorDataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.EmailVerifyDao;
import zeryasoft.hrms.entities.concretes.EmailVerify;

@Service
public class EmailVerifyManager implements EmailVerifyService{
	
	private EmailVerifyDao emailVerifyDao;

	@Autowired
	public EmailVerifyManager(EmailVerifyDao emailVerifyDao) {

		super();
		this.emailVerifyDao = emailVerifyDao;
	}

	public Result verify(String verificationCode, Integer id) {

		EmailVerify ref = this.emailVerifyDao.findById(id).get();
		if (ref.getCode().equals(verificationCode)) {
			ref.setVerified(true);
			return new SuccessDataResult<EmailVerify>(this.emailVerifyDao.save(ref), "Doğrulama Kodu Geçerli, İşlem Başarılı!");
		}
		return new ErrorDataResult<EmailVerify>(null, "Doğrulama Kodu Geçersiz, İşlem Başarısız Lütfen Tekrar Deneyin!");

	}

	@Override
	public void generateCode(EmailVerify code, Integer id) {
		EmailVerify code_ = code;
		code_.setCode(null);
		code_.setVerified(false);
		if (code_.isVerified() == false) {
			GenerateRandomCode generator = new GenerateRandomCode();
			String code_create = generator.Create(id);
			code_.setCode(code_create);
			code_.setId(id);

			emailVerifyDao.save(code_);

		}
		return;
	}

}
