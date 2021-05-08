package eTicaret.entities.concretes;

import eTicaret.entities.abstracts.Entity;

public class User implements Entity{
	private int Id;
	private String firstName;
	private String lastName;
	private String mail;
	private String password;
	private boolean isVeryfied;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String firstName, String lastName, String mail, String password) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mail = mail;
		this.password = password;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void seteMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isVeryfied() {
		return isVeryfied;
	}

	public void setVeryfied(boolean isVeryfied) {
		this.isVeryfied = isVeryfied;
	}
}
