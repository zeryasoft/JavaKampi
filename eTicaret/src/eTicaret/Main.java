package eTicaret;

import eTicaret.business.concretes.UserManager;
import eTicaret.business.concretes.VerificationManager;
import eTicaret.core.servis.LoginWithGmailAdapter;
import eTicaret.core.servis.MailSender;
import eTicaret.core.servis.VerificationMailSender;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.dataAccess.concretes.HibernateUserDao;
import eTicaret.entities.concretes.User;

public class Main {
	
	public static void main(String[] args) {
		User user=new User();
		user.setId(1);
		user.setFirstName("Sedat");
		user.setLastName("KOÇ");
		user.seteMail("aaas@asss");
		user.setPassword("as5ddf61");
		
		
				
		UserDao userDao=new HibernateUserDao(user);
		UserManager userManager=new UserManager(userDao,new LoginWithGmailAdapter());
		
		userManager.register(user);
		userManager.register(user);
		userManager.register(user);
		
		userManager.login(user,"aaas@asss", "as5ddf61");
		
		userManager.loginWithGoogle(user,"aaas@asss","as5ddf61");
		

		for (User userName : userManager.getAll()) {
			System.out.println(userName.getFirstName());
		} 
		
		VerificationManager verificationManager=new VerificationManager(new VerificationMailSender());
		verificationManager.verificate("aaas@asss");
		
		
		userManager.delete(user, 1);
		
	}

}
