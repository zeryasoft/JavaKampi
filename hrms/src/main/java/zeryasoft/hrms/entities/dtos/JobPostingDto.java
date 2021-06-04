package zeryasoft.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingDto {
	
	private int id;
	private String companyName;
	private String jobTitle;
	private int numberOfNeeds;
	private String releaseDate;
	private String applicationDeadline;	
}
