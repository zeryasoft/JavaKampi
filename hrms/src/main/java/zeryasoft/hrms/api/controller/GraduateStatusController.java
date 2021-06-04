package zeryasoft.hrms.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.GraduationStatusService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.GraduationStatus;

@RestController
@RequestMapping("/api/graduate")
public class GraduateStatusController {

	private GraduationStatusService graduationStatusService;

	@Autowired
		public GraduateStatusController(GraduationStatusService graduationStatusService) {
			super();
			this.graduationStatusService = graduationStatusService;
		}

	@GetMapping("/getall")
	public DataResult<List<GraduationStatus>> getAll() {
		return this.graduationStatusService.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody GraduationStatus graduationStatus) {
		return this.graduationStatusService.add(graduationStatus);
	}
}
