package eTicaret.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class HibernateUserDao implements UserDao{

	 private List<User> users;

	    public HibernateUserDao(){

	    }
	    
	    public HibernateUserDao(User user) {

	        this.users = new ArrayList<User>();
		}

		@Override
	    public void add(User user) {
	        this.users.add(user);
	        System.out.println("Kullanýcý veritabanýna eklendi");
	    }

	    @Override
	    public void update(User user) {
	        System.out.println("Güncelleme þu anda devredýþý");
	    }

	    @Override
	    public void delete(User user) {
	    	int userToDelete = this.users.indexOf(user);
	        this.users.remove(userToDelete);
	        System.out.println("Kullanýcý veritabanýndan silindi.");
	    }

	    @Override
	    public User get(int id) {
	        
	        User userToReturn = null;
	        for(User user: this.users){
	            if(user.getId() == id){
	                userToReturn = user;
	                break;
	            }
	        }
	        return userToReturn;
	    }
	   

	    @Override
	    public List<User> getAll() {
	        return users;
	    }


		@Override
		public boolean getByMail(User user, String mail) {
			if(user.getMail()==mail) {
				return true;
			}
			return false;
		}

	  
}
