package interfaceAbstractDemo.concrete;

import interfaceAbstractDemo.abstractt.BaseCustomerManager;
import interfaceAbstractDemo.abstractt.CustomerCheckService;
import interfaceAbstractDemo.entities.Customer;

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
