package gameSeller.concrete;

import gameSeller.Abstract.CustomerCheckService;
import gameSeller.Abstract.CustomerService;
import gameSeller.entities.Customer;

public class CustomerManager implements CustomerService{
	CustomerCheckService checkService;

	public CustomerManager(CustomerCheckService checkService) {
		this.checkService = checkService;
	}
	
	@Override
	public void add(Customer customer) {
		if(checkService.CheckIfRealPerson(customer)) {
			System.out.println("Customer added :"+customer.getFirstName());
		}
		else {
			System.out.println("Not a Valid Person");
		}
		
	}

	@Override
	public void update(Customer customer) {
		if(checkService.CheckIfRealPerson(customer)) {
			System.out.println("Customer updated "+customer.getFirstName());
		}
		else {
			System.out.println("Not a Valid Person");
		}
		
	}

	@Override
	public void delete(Customer customer) {
		if(checkService.CheckIfRealPerson(customer)) {
			System.out.println("Customer deleted :"+customer.getFirstName());
		}
		else {
			System.out.println("Not a Valid Person");
		}
	}

	@Override
	public String[] getById(Customer customer) {
		String[] customerInfo= {customer.getFirstName(),customer.getLastName(),customer.getNationalityId(),String.valueOf(customer.getBirthOfDateYear())};
		return customerInfo;
	}

}
