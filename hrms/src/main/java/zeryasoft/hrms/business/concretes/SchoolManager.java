package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.SchoolService;
import zeryasoft.hrms.core.utilities.dtoConverter.DtoConverterService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.SchoolDao;
import zeryasoft.hrms.entities.concretes.School;
import zeryasoft.hrms.entities.dtos.SchoolDto;

@Service
public class SchoolManager implements SchoolService{
	
	private SchoolDao schoolDao;
	private DtoConverterService dtoConverterService;
		
	@Autowired
	public SchoolManager(SchoolDao schoolDao, DtoConverterService dtoConverterService) {
		super();
		this.schoolDao = schoolDao;
		this.dtoConverterService = dtoConverterService;
	}
	
	@Override
	public Result add(SchoolDto educationDto) {
		schoolDao.save((School) dtoConverterService.dtoClassConverter(educationDto, School.class));
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<List<SchoolDto>> getAll() {
		return new SuccessDataResult<List<SchoolDto>>(dtoConverterService.dtoConverter(schoolDao.findAll(), SchoolDto.class));

	}

}
