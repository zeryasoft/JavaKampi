package zeryasoft.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import zeryasoft.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{
	
}
