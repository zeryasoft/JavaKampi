package gameSeller.Abstract;

import gameSeller.entities.Customer;

public interface CustomerService {
	
	String [] getById(Customer customer);
	void add(Customer customer);
	void update(Customer customer);
	void delete(Customer customer);
}
