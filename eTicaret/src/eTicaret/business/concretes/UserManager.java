package eTicaret.business.concretes;

import java.util.List;
import eTicaret.business.abstracts.UserService;
import eTicaret.core.ValidationTool;
import eTicaret.core.servis.LoginWithGmailService;
import eTicaret.core.servis.VerificationMailSender;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private UserService userService;

    private LoginWithGmailService loginWithGmailService;
    
	 public UserManager(UserDao userDao, LoginWithGmailService loginWithGmailService) {
		 this.userDao=userDao;
		 this.loginWithGmailService=loginWithGmailService;
	 }
	
	@Override
	public void register(User user) {

		if(!ValidationTool.butunAlanlarDoluMu(user)) {
		    System.out.println("Alanlar Boþ Býrakýlamaz");
		    return;
		}		

		if(ValidationTool.isFirstNameAndLastNameValid(user)) {
			System.out.println("Ad ve Soyad Min 2 Karaktar Olmalý");
			return;
		}
		
		if(!ValidationTool.password(user)) {
			System.out.println("Þifre Min 6 Karaktar Olmalý");
			return;
		}		
		
		if(!ValidationTool.isEmailValid(user.getMail())) {
			System.out.println("Mail Adresi Doðru Biçimde Deðil");
			return;
		}	
		this.userDao.add(user);
		System.out.println("Kayýt Ýþlemi Baþarýlý, Doðrulama linki Mail Adresinize gönderildi :"+user.getMail());
	}
	
    @Override
    public void delete(User user, int id) {
        if(user.getMail() != null && user.getId()!=id){
            System.out.println("Kullanýcý silinemez.");
            return;
        }
        this.userDao.delete(user);
    }

    @Override
    public User get(int id) {
        return this.userDao.get(id);
    }

    @Override
    public List<User> getAll() {
        return this.userDao.getAll();
    }
   
    public User getByMail(String mail){
    	
        User foundedUser = this.userService.getByMail(mail);
        return foundedUser;
    }
   

	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}

	VerificationMailSender mailSender=new VerificationMailSender();
	
	@Override
	public boolean login(User user,String mail, String password) {
	    boolean userToCheck = this.userDao.getByMail(user,mail);
	    if(userToCheck == false){
	        System.out.println("Kayýtlý kullanýcý bulunamadý");
	        return false;
	    }
	    if(!user.getPassword().equals(password)){
	        System.out.println("Mail ya da parola yanlýþ");
	        return false;
	    }
	    System.out.println("Giriþ baþarýlý...");
		mailSender.send("aaas@asss");
	    return true;
	}
	
	@Override
	public boolean loginWithGoogle(User user,String mail, String password) {

	    if(!loginWithGmailService.login(user.getMail(),user.getPassword())){
	        System.out.println("Google bilgilerinizi onaylamadý");
	        return false;
	    }
	    
		boolean getMail=this.userDao.getByMail(user,mail);
		if(getMail== false){
			this.userDao.add(user);
		}

		System.out.println("Giriþ baþarýlý...");
		mailSender.send("aaas@asss");
		return true;
	}
	

	

}
