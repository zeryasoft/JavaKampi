package zeryasoft.hrms.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.business.abstracts.ResumeService;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/jobpostingforms")
public class ResumeController {
	
	private ResumeService resumeService;
	
	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@GetMapping("/getall")
	public Result getAll(){
		return this.resumeService.getAll();
	}
		
	@PostMapping(value="/add")
	public Result add(@Valid @RequestBody Resume resume) {
		return this.resumeService.add(resume);				
	  }
	
	@PutMapping("/uploadImage")
	public Result saveImage(@RequestParam MultipartFile file,@RequestParam int resumeId) {
		return this.resumeService.saveImage(file,resumeId);
	}
}
