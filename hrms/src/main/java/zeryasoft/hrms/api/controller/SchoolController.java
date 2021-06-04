package zeryasoft.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.SchoolService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.dtos.SchoolDto;

@RestController
@RequestMapping("api/school")
public class SchoolController {
	
	private SchoolService schoolService;	

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<SchoolDto>> getAll(){
		return this.schoolService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody SchoolDto schoolDto) {
		return this.schoolService.add(schoolDto);
	  }
}
