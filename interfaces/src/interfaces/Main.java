package interfaces;

public class Main {

	public static void main(String[] args) {
		
		Logger[] loggers=new Logger[] {new SmsLogger(), new DatabaseLogger(), new FileLogger()};
		
		CustomerManager customerManager=new CustomerManager(loggers);
		
		Customer sedat=new Customer(1,"Sedat","KOÇ");
		customerManager.add(sedat);


		
		
		
	}

}
