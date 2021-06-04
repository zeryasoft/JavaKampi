package zeryasoft.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.ProgrammingLanguageService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("api/programmingLanguage")
public class ProgrammingLanguageController {
	
	private ProgrammingLanguageService programmingLanguageService;

	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}

	@GetMapping("/getall")
	public DataResult<List<ProgrammingLanguage>> getAll(){
		return this.programmingLanguageService.getAll();
	}
	
	
	@PostMapping("/add")
	public Result add(@Valid @RequestBody ProgrammingLanguage technology) {
		return this.programmingLanguageService.add(technology);
	  }
	
}
