package zeryasoft.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.EmailVerifyService;
import zeryasoft.hrms.business.abstracts.UserService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.ErrorDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.UserDao;
import zeryasoft.hrms.entities.concretes.EmailVerify;
import zeryasoft.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	private EmailVerifyService emailVerifyService;

	@Autowired
	public UserManager(UserDao userDao, EmailVerifyService emailVerifyService) {
		super();
		this.userDao = userDao;
		this.emailVerifyService=emailVerifyService;
	}

	@Override
	public List<User> getAll() {
		return userDao.findAll();
	}

	@Override
	public DataResult<List<User>> getById(int id) {
		return new SuccessDataResult<List<User>>(userDao.getById(id),
				id + " nolu id'ye sahip Kullanıcı Bilgisi Getirildi.");
	}

	@Override
	public DataResult<User> add(User user) {
		if (!emailNullChecker(user)) {
			return new ErrorDataResult<User>(null, "Email Alanı Boş Bırakılamaz!");
		}
		
		if (userDao.findAllByEmail(user.getEmail()).stream().count() != 0) {
			return new ErrorDataResult<User>(null, "Bu Email Adresi Sistemde Zaten Mevcut!");
		}
		
		if (!passwordNullChecker(user)) {
			return new ErrorDataResult<User>(null, "Şifre Alanı Boş Bırakılamaz!");
		}	
		
		if (!isRealEmail(user)) {
			return new ErrorDataResult<User>(null, "Girilen Email Adresi Doğru Değildir!");
		}
			
		this.emailVerifyService.generateCode(new EmailVerify(), user.getId());
		
		return new SuccessDataResult<User>(this.userDao.save(user),"User Added Successfully");
	}
	
	private boolean emailNullChecker(User user) {
		if (user.getEmail().isBlank() || user.getEmail().equals(null)) {
			return false;
		}
		return true;
	}
	
	private boolean isRealEmail(User user) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		
		if (!matcher.matches()) {
			return false;
		}
		return true;
	}
	
	private boolean passwordNullChecker(User user) {
		if (user.getPassword().isBlank() || user.getPassword().equals(null)) {
			return false;
		}
		return true;
	}
}
