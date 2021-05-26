package zeryasoft.hrms.core.utilities;

import zeryasoft.hrms.core.adapters.MernisSimulation;

public class IdentityValidation {
	
	public static boolean isRealPerson(String tcno) {
		return MernisSimulation.Validation(tcno);

	}
}
