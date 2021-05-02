package interfaceAbstractDemo;

import Adapters.MernisServiceAdapter;
import interfaceAbstractDemo.abstractt.BaseCustomerManager;
import interfaceAbstractDemo.concrete.StarbucksCustomerManager;
import interfaceAbstractDemo.entities.Customer;

public class Main {

	public static void main(String[] args) {
		
		BaseCustomerManager baseCustomerManager=new StarbucksCustomerManager(new MernisServiceAdapter());
		Customer customer=new Customer();
		customer.setId(1);
		customer.setFirstName("Sedat");
		customer.setLastName("KOÇ");
		customer.setDate(1111);
		customer.setNationalityId("11111111111");
		baseCustomerManager.save(customer);
			
		
	}
}
