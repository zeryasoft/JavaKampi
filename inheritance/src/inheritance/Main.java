package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividualCustomer individualCustomer=new IndividualCustomer();
		individualCustomer.customerNumber="36255";
		
		CorporateCustomer corporateCustomer=new CorporateCustomer();
		corporateCustomer.customerNumber="494646";
				
		Customer[] customers= {individualCustomer,corporateCustomer};
		

		CustomerManager customerManager=new CustomerManager();
		//customerManager.add(individualCustomer);
		//customerManager.add(corporateCustomer);
		customerManager.addMultiple(customers);
	}

}
