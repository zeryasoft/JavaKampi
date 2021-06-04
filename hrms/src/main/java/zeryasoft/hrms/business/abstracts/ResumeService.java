package zeryasoft.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.core.utilities.results.DataResult;
import zeryasoft.hrms.core.utilities.results.Result;
import zeryasoft.hrms.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(Resume resume);	
	DataResult<List<Resume>> getAll();
	Result saveImage(MultipartFile file, int resumeId);
}
