package zeryasoft.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.Resume;
import zeryasoft.hrms.entities.dtos.ResumeDto;

public interface ResumeService {

	Result add(ResumeDto resumeDto);

	DataResult<List<ResumeDto>> getAll();
	
	DataResult<List<Resume>> getAllResume();

	Result saveImage(MultipartFile file, int resumeId);
}
