package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.UserService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return this.userService.getAll();
	}
	
	@GetMapping("/getByUserId")
	public DataResult<List<User>> getByUserId(int id) {
		return this.userService.getById(id);
	}
	
	@PostMapping("/add")
	public DataResult<User> add(@RequestBody User user) {
		return this.userService.add(user);
	}
}
