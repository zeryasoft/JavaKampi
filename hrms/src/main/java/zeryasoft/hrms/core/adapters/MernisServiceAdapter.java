package zeryasoft.hrms.core.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
import zeryasoft.hrms.entities.concretes.Candidate;

public class MernisServiceAdapter{

	public boolean CheckIfRealPerson(Candidate candidate) {	
		KPSPublicSoap client = new KPSPublicSoapProxy();
		try {
			return client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(new Locale("tr")),
					candidate.getLastName().toUpperCase(new Locale("tr")),
					candidate.getBirthYear());
		} catch (RemoteException e) {
			return false;
		}
	}

}
