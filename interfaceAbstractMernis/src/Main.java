import Adapters.MernisServiceAdapter;
import Entities.Customer;
import abstracts.BaseCustomerManager;
import concretes.StarbucksCustomerManager;

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
