package zeryasoft.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id")
	private Resume resume;
	
	@NotBlank(message="Boş Geçilemez")
	@Column(name="company_name")
	private String companyName;
	
	@ManyToOne(targetEntity = JobTitle.class)
	@JoinColumn(name = "job_title_id", referencedColumnName =  "id" ,nullable = false)
	private JobTitle jobTitle;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="leaving_date")
	private Date leavingDate;
	
	@Column(name="added_date")
	private Date addedDate;
	

}
