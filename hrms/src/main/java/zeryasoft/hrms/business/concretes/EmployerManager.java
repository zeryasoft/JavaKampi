package zeryasoft.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.EmailVerifyService;
import zeryasoft.hrms.business.abstracts.EmployerService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.ErrorDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.EmployerDao;
import zeryasoft.hrms.entities.concretes.EmailVerify;
import zeryasoft.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private EmailVerifyService emailVerifyService;

	@Autowired
	public EmployerManager(EmployerDao employerDao,EmailVerifyService emailVerifyService) {
		super();
		this.employerDao=employerDao;
		this.emailVerifyService=emailVerifyService;
	}

	@Override
	public List<Employer> getAll() {
		return this.employerDao.findAll();
	}

	@Override
	public DataResult<Employer> add(Employer employer) {
		if (!companyNameValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Şirket Adı Alanı Boş Bırakılamaz!");
		} else if (!webSiteValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> WebSite Adresi Alanı Boş Bırakılamaz!");
			
			  } else if (!isRealEmployer(employer)) { return new
			  ErrorDataResult<Employer>(null,
			  " -> Geçersiz Email Adresi, Lütfen Tekrar Deneyin!");
			 
		} else if (!passwordNullValid(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Şifre Alanı Boş Bırakılamaz!");

		} else if (!isRealPhoneNumber(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Geçersiz Telefon Numarası Lütfen Tekrar Deneyin!");

		} else if (!isEmailAlreadyRegistered(employer)) {
			return new ErrorDataResult<Employer>(null, " -> Bu Email Adresi Sistemde Zaten Mevcut, Tekrar Deneyin!");
		}
		
		this.emailVerifyService.generateCode(new EmailVerify(), employer.getId());
		return new SuccessDataResult<Employer>(this.employerDao.save(employer),
				" -> İş Veren Hesabı Eklendi! Doğrulama Kodu Gönderildi: " + employer.getId());
	}

	private boolean companyNameValid(Employer employer) {

		if (employer.getCompanyName().isBlank() || employer.getCompanyName() == null) {
			return false;
		}
		return true;
	}

	private boolean webSiteValid(Employer employer) {
		if (employer.getWebAddress().isBlank() || employer.getWebAddress() == null) {
			return false;
		}
		return true;
	}

	private boolean isRealEmployer(Employer employer) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(employer.getEmail());
		if (!matcher.matches()) {
			return false;
		} else if (!employer.getEmail().contains(employer.getWebAddress())) {
			return false;
		}
		return true;
	}

	private boolean isEmailAlreadyRegistered(Employer employer) {
		if (employerDao.findAllByEmail(employer.getEmail()).stream().count() != 0) {
			return false;
		}
		return true;
	}

	private boolean passwordNullValid(Employer employer) {
		if (employer.getPassword().isBlank() || employer.getPassword() == null) {
			return false;
		}
		return true;
	}

	private boolean isRealPhoneNumber(Employer employer) {
		String patterns = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
				+ "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";

		Pattern pattern = Pattern.compile(patterns);
		Matcher matcher = pattern.matcher(employer.getPhoneNumber());
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}

}
