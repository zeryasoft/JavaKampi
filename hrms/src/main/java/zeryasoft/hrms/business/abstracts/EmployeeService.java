package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();
}
