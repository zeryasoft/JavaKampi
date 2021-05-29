package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.JobPostingFormService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.dataAccess.abstracts.JobPostingFormDao;
import zeryasoft.hrms.entities.concretes.JobPostingForm;


@Service
public class JobPostingFormManager implements JobPostingFormService{
	
	private JobPostingFormDao jobPostingFormDao;
	@Autowired
	public JobPostingFormManager(JobPostingFormDao jobPostingFormDao) {
		super();
		this.jobPostingFormDao=jobPostingFormDao;
	}
	@Override
	public DataResult<JobPostingForm> add(JobPostingForm jobPostingForm) {
		return new SuccessDataResult<JobPostingForm>(this.jobPostingFormDao.save(jobPostingForm),"Kayıt İşlemi Başarılı");
	}
	@Override
	public DataResult<List<JobPostingForm>> getByActivatedPosting(boolean isActivated) {		
		return new SuccessDataResult<List<JobPostingForm>>
		(this.jobPostingFormDao.getByIsActivated(isActivated),"Aktif İlanlar Listelendi");
	}
	

}
