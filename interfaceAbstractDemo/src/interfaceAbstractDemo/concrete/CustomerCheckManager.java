package interfaceAbstractDemo.concrete;

import interfaceAbstractDemo.abstractt.CustomerCheckService;
import interfaceAbstractDemo.entities.Customer;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		return true;		
	}

}
