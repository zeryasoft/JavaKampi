package zeryasoft.hrms.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zeryasoft.hrms.business.abstracts.CityService;
import zeryasoft.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CityController {
	
	private CityService cityService;
	
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getAll")
	public List<City> getAll(){
		return this.cityService.getAll();
	}
}
