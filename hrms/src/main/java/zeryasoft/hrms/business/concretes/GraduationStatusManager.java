package zeryasoft.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zeryasoft.hrms.business.abstracts.GraduationStatusService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.ErrorResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.GraduationStatusDao;
import zeryasoft.hrms.entities.concretes.GraduationStatus;

@Service
public class GraduationStatusManager implements GraduationStatusService{

	private GraduationStatusDao graduationStatusDao;
	
	@Autowired
	public GraduationStatusManager(GraduationStatusDao graduationStatusDao) {
		super();
		this.graduationStatusDao = graduationStatusDao;
	}
	@Override
	public DataResult<List<GraduationStatus>> getAll() {
		return new SuccessDataResult<List<GraduationStatus>>(this.graduationStatusDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(GraduationStatus graduationStatus) {
		if (graduationStatusDao.existsByGraduation(graduationStatus.getGraduation())) {
			return new ErrorResult("Daha önce Eklendi");
		}
		
		this.graduationStatusDao.save(graduationStatus);
		return new SuccessResult("Eklendi");
	}

}
