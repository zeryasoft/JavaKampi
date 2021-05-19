package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.CandidateService;
import zeryasoft.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;

	public CandidateController(CandidateService candidateService) {
		super();
		this.candidateService=candidateService;
	}
	
	@GetMapping("/getAll")
	public List<Candidate> getAll(){
		return this.candidateService.getAll();
	}
}
