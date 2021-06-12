package zeryasoft.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.business.abstracts.ResumeService;
import zeryasoft.hrms.core.utilities.CloudinaryService;
import zeryasoft.hrms.core.utilities.dtoConverter.DtoConverterService;
import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.core.utilities.results.SuccessDataResult;
import zeryasoft.hrms.core.utilities.results.SuccessResult;
import zeryasoft.hrms.dataAccess.abstracts.ResumeDao;
import zeryasoft.hrms.entities.concretes.Resume;
import zeryasoft.hrms.entities.dtos.ResumeDto;

@Service
public class ResumeManager implements ResumeService {

	private ResumeDao resumeDao;
	private CloudinaryService cloudinaryService;
	private DtoConverterService dtoConverterService;

	@Autowired
	public ResumeManager(ResumeDao resumeDao, CloudinaryService cloudinaryService,
			DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.cloudinaryService = cloudinaryService;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result saveImage(MultipartFile file, int resumeId) {
		@SuppressWarnings("unchecked")
		Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
		String imageUrl = uploader.get("url");
		Resume Cv = resumeDao.getOne(resumeId);
		Cv.setPhoto(imageUrl);
		resumeDao.save(Cv);
		return new SuccessResult("Kayıt Başarılı");

	}

	@Override
	public Result add(ResumeDto resumeDto) {
		resumeDao.save((Resume) dtoConverterService.dtoClassConverter(resumeDto, Resume.class));
		return new SuccessResult("Kayıt Başarılı");
	}

	@Override
	public DataResult<List<ResumeDto>> getAll() {
		return new SuccessDataResult<List<ResumeDto>>(
				dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeDto.class), "Data Listelendi");

	}

	@Override
	public DataResult<List<Resume>> getAllResume() {
		return new SuccessDataResult<List<Resume>>(resumeDao.findAll(), "Data Listelendi");
	}

}
