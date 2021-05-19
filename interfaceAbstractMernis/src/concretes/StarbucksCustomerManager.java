package concretes;

import Entities.Customer;
import abstracts.BaseCustomerManager;
import abstracts.CustomerCheckService;

public class StarbucksCustomerManager extends BaseCustomerManager{
	
	CustomerCheckService customerCheckService;
	public StarbucksCustomerManager(CustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}

	@Override
	public void save(Customer customer) {
		if(customerCheckService.CheckIfRealPerson(customer)) {
			System.out.println("Saved to Db "+customer.getFirstName()+" "+customer.getDate());
		}
		else {
			System.out.println("Not a Valid Person");
		}		
	}	
}
