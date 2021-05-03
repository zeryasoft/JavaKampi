package gameSeller.Abstract;

import gameSeller.entities.Customer;

public interface CustomerCheckService {
	boolean CheckIfRealPerson(Customer customer);
}
