package zeryasoft.hrms.core.utilities;

import org.springframework.web.multipart.MultipartFile;

import zeryasoft.hrms.core.utilities.results.DataResult;

public interface CloudinaryService {
	DataResult<?> save(MultipartFile file);
}
