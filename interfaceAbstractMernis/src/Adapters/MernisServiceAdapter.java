package Adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import Entities.Customer;
import abstracts.CustomerCheckService;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean CheckIfRealPerson(Customer customer) {

		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(Long.parseLong(customer.getNationalityId()), 
					customer.getFirstName().toUpperCase(new Locale("tr")), customer.getLastName().toUpperCase(new Locale("tr")), customer.getDate());
		}  catch (RemoteException e) {
			return false;
		}
	}

}