package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.CityService;
import zeryasoft.hrms.dataAccess.abstracts.CityDao;
import zeryasoft.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao=cityDao;
	}
	@Override
	public List<City> getAll() {
		return cityDao.findAll();
	}

}
