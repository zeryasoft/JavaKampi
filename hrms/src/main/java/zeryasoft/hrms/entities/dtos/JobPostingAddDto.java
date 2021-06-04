package zeryasoft.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobPostingAddDto {

	@JsonIgnore
	private int id;
	private int employerId;
	private int jobTitleId;
	private int numberOfNeeds;
	private int minSalary;
	private int maxSalary;
	private int cityId;	
	private Date releaseDate;
	private Date applicationDeadline;
	private String jobDescription;
	
}
