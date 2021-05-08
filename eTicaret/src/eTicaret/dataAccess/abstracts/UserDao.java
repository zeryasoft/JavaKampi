package eTicaret.dataAccess.abstracts;

import java.util.List;

import eTicaret.entities.concretes.User;

public interface UserDao {
	 void add(User user);
	 void update(User user);
	 void delete(User user);
	 User get(int id);
	 boolean getByMail(User user,String mail);
	 List<User> getAll();

}
