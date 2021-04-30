package classInheritance;

public class Main {

	public static void main(String[] args) {
		
		UIManager uiManager=new UIManager(new InstructorManager());
		uiManager.Add();
		
		UserManager[] userManagers=new UserManager[] {new StudentManager(), new InstructorManager()};
		
		for (UserManager userManager : userManagers) {
			userManager.getList();;
		}
	}

}
