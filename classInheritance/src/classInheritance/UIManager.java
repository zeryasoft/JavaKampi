package classInheritance;

public class UIManager {
	UserManager userManager;
	public UIManager(UserManager userManager) {
		this.userManager=userManager;
	}
	
	public void Add() {
		this.userManager.getList();
	}
	
}
