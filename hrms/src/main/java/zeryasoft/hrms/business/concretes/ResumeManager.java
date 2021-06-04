package zeryasoft.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.business.abstracts.ResumeService;
import zeryasoft.hrms.core.utilities.CloudinaryService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.ResumeDao;
import zeryasoft.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao,CloudinaryService cloudinaryService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService=cloudinaryService;
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData(); 	
		String imageUrl= uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public Result add(Resume resume) {
		if (resume.getForeignLanguages() != null) {
			resume.getForeignLanguages().forEach(forLang -> forLang.setResume(resume));
		}
		if (resume.getSchool() != null) {
			resume.getSchool().forEach(school -> school.setResume(resume));
		}
		if (resume.getProgrammingLanguages() != null) {
			resume.getProgrammingLanguages().forEach(progLang -> progLang.setResume(resume));
		}
		if (resume.getJobExperiences() != null) {
			resume.getJobExperiences().forEach(exper -> exper.setResume(resume));
		}
				
		resumeDao.save(resume);
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<Resume>> getAll() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(),"Data Listelendi");
	}

}
