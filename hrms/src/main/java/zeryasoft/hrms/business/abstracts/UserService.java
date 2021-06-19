package zeryasoft.hrms.business.abstracts;

import java.util.List;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.User;


public interface UserService {
	List<User>getAll();
	DataResult<List<User>>getById(int id);
	DataResult<User> add(User user);
}
