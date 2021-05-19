package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.EmployeeService;
import zeryasoft.hrms.dataAccess.abstracts.EmployeeDao;
import zeryasoft.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{
	
	private EmployeeDao employeeDao;

	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao=employeeDao;
	} 
	
	@Override
	public List<Employee> getAll(){
		return this.employeeDao.findAll();
	}
}
