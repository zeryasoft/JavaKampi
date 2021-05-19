package concretes;

import Entities.Customer;
import abstracts.CustomerCheckService;

public class CustomerCheckManager implements CustomerCheckService{

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		return true;		
	}

}
