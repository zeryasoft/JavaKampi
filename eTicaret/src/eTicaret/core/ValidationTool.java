package eTicaret.core;

import java.util.regex.Pattern;

import eTicaret.entities.concretes.User;

public class ValidationTool {
	
	public static boolean isEmailValid(String email) {
	    final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
	    return EMAIL_REGEX.matcher(email).matches();
	}
	
	public static boolean butunAlanlarDoluMu(User user) {
		boolean[] txtIsEmpty= {user.getFirstName().isBlank(),user.getLastName().isBlank(),user.getPassword().isBlank(),user.getMail().isBlank()};
		for (boolean item : txtIsEmpty) {
			if(item==true) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean password(User user) {
		return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{6,}$", user.getPassword());			
	}
	
	public static boolean isFirstNameAndLastNameValid(User user) {
		if(user.getFirstName().length()<2 || user.getLastName().length()<2) {
			return true;
		}
		return false;
	}
	/*
	public static boolean isUserNameAvalaible(List<User> userList, User user) {
		for (User iterator : userList)
		{
			if (user.getMail().equals(iterator.getMail()) == true)
			{
				return true;
			}
		}
		return false;
	}
	*/
}
