package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.JobPostingService;
import zeryasoft.hrms.core.utilities.dtoConverter.DtoConverterService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.JobPostingDao;
import zeryasoft.hrms.entities.concretes.JobPosting;
import zeryasoft.hrms.entities.dtos.JobPostingAddDto;
import zeryasoft.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	private DtoConverterService dtoConverterService;
	private ModelMapper modelMapper;

	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao,DtoConverterService dtoConverterService,ModelMapper modelMapper) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.dtoConverterService=dtoConverterService;
		this.modelMapper=modelMapper;
	}

	@Override
	public DataResult<JobPosting> add(JobPosting jobPosting) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.save(jobPosting),
				"Kayıt İşlemi Başarılı");
	}
	@Override
	public Result addDto(JobPostingAddDto jobPostingAddDto) {
		this.jobPostingDao.save(dtoConvert(jobPostingAddDto));
		return new SuccessResult("Kayıt İşlemi Başarılı");
	}
	private JobPosting dtoConvert(JobPostingAddDto jobPostingAddDto) {
		return modelMapper.map(jobPostingAddDto, JobPosting.class);
	}
	
	
	
	//Aktif Pasif Tüm iş ilanlarını getirir
	@Override
	public DataResult<List<JobPosting>> getAllJobPosting() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}
	
	// Tüm Aktif iş ilanları 1 with Dto 
	@Override
	public DataResult<List<JobPostingDto>> findByIsActivated(boolean isActivated) {
		return new SuccessDataResult<List<JobPostingDto>>(dtoConverterService.dtoConverter
				(jobPostingDao.findByIsActivated(isActivated), JobPostingDto.class));
	}
	
	// Tüm Aktif iş ilanları 2
	@Override
	public DataResult<List<JobPosting>> getAllActivatedJobPosting() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getActivatedJobPosting(true),"Aktif İlanlar Listelendi");
	}


	//Employer Idsine göre Actif ilanlar
	@Override
	public DataResult<List<JobPosting>> getByActivatedEmployerId(int employer_id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getByEmployerId(employer_id)," Şirket Idsine Ait Aktif İlanlar Listelendi");
	}
	

	// ilan tarihine göre aktif iş ilanları
	@Override
	public DataResult<List<JobPostingDto>> findByIsActiveOrderByClosedDate() {
		return new SuccessDataResult<List<JobPostingDto>>
		(this.dtoConverterService.dtoConverter(this.jobPostingDao.findByIsActiveOrderByClosedDate(true), 
				JobPostingDto.class),"Data Listelendi");
	}
	
	@Override
	public DataResult<List<JobPosting>> updateJobPostingIsActivatedForEmployerId(int jobPostingId) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.updateJobPostingIsActivatedForEmployerId(jobPostingId),"İlan pasif hale getirildi");
	}

	/*
	 * @Override public DataResult<List<JobPostingDto>>
	 * getByCompanyNameAndIsActivatedTrue(String companyName) { return new
	 * SuccessDataResult<List<JobPostingDto>>
	 * (this.dtoConverterService.dtoConverter(this.jobPostingDao.
	 * findByEmployerCompanyNameAndIsActive(true,companyName),
	 * JobPostingDto.class)); }
	 */
}
