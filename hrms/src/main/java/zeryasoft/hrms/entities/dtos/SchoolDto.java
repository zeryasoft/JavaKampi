package zeryasoft.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {
	
	@JsonIgnore
	private int id;
	private int resumeId;
	private String schoolName;
	private int graduateId;
	private String department;
	private int startYear;
	private int graduationYear;
	private Date addedDate;
}
