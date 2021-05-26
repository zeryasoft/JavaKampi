package zeryasoft.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.CandidateService;
import zeryasoft.hrms.business.abstracts.EmailVerifyService;
import zeryasoft.hrms.core.utilities.IdentityValidation;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.ErrorDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.CandidateDao;
import zeryasoft.hrms.entities.concretes.Candidate;
import zeryasoft.hrms.entities.concretes.EmailVerify;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private EmailVerifyService emailVerifyService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, EmailVerifyService emailVerifyService) {//
		super();
		this.candidateDao = candidateDao;
		this.emailVerifyService = emailVerifyService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data Listelendi");
	}

	@Override
	public DataResult<Candidate> add(Candidate candidate) {

		if (!firstNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Ad Alanı Boş Bırakılamaz!");
		}

		if (!lastNameChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Soyad Alanı Boş Bırakılamaz!");
		}

		if (candidate.getIdentityNumber().isBlank()) {
			return new ErrorDataResult<Candidate>(null, "TC Kimlik Numarası Alanı Boş Bırakılamaz!");
		}

		if (!birthDateChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Doğum Tarihi Alanı Boş Bırakılamaz!");
		}

		if (!emailNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Email Alanı Boş Bırakılamaz!");
		}

		if (!passwordNullChecker(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Şifre Alanı Boş Bırakılamaz!");
		}

		if (!IdentityValidation.isRealPerson(candidate.getIdentityNumber())) {
			return new ErrorDataResult<Candidate>(null, "TC Kimlik Numarası Doğrulanmadı, Tekrar Deneyin!");
		}

		if (!isRealEmail(candidate)) {
			return new ErrorDataResult<Candidate>(null, "Girilen Email Adresi Doğru Değildir!");
		}

		if (candidateDao.findAllByEmail(candidate.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(null, "Bu Email Adresi Sistemde Zaten Mevcut!");
		}

		if (candidateDao.findAllByIdentityNumber(candidate.getIdentityNumber()).stream().count() != 0) {
			return new ErrorDataResult<Candidate>(null, "Bu TC Kimlik Numarası Sistemde Zaten Mevcut!");
		}

		this.emailVerifyService.generateCode(new EmailVerify(), candidate.getId());
		return new SuccessDataResult<Candidate>(this.candidateDao.save(candidate),"İş Arayan Hesabı Eklendi! Doğrulama Kodu Gönderildi: " + candidate.getId());
	}

	private boolean firstNameChecker(Candidate candidate) {
		if (candidate.getFirstName().isBlank() || candidate.getFirstName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean lastNameChecker(Candidate candidate) {
		if (candidate.getLastName().isBlank() || candidate.getLastName().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean birthDateChecker(Candidate candidate) {
		if (candidate.getBirthYear() == 0) {
			return false;
		}
		return true;
	}

	private boolean emailNullChecker(Candidate candidate) {
		if (candidate.getEmail().isBlank() || candidate.getEmail().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean passwordNullChecker(Candidate candidate) {
		if (candidate.getPassword().isBlank() || candidate.getPassword().equals(null)) {
			return false;
		}
		return true;
	}

	private boolean isRealEmail(Candidate candidate) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(candidate.getEmail());
		if (!matcher.matches()) {
			return false;
		}
		return true;

	}
}
