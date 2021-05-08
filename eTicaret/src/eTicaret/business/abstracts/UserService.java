package eTicaret.business.abstracts;

import java.util.List;

import eTicaret.entities.concretes.User;

public interface UserService {
	void add(User user);
    void delete(User user, int id);
    User get(int id);
    List<User> getAll();
    User getByMail(String mail);
	void register(User user);

	boolean login(User user, String mail,String password);
	

	 boolean loginWithGoogle(User user,String mail, String password);
}
