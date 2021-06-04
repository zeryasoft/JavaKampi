package zeryasoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_posting_forms")
public class JobPosting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable = false,nullable = false)
	private int jobPostingId;

	@Column(name = "job_description")
	private String jobDescription;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "number_of_needs")
	private int numberOfNeeds;

	@Column(name = "release_date")
	private String releaseDate;

	@Column(name = "application_deadline")
	private String applicationDeadline;

	@Column(name = "is_activated")
	private boolean isActivated;

	@ManyToOne(targetEntity = Employer.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "employer_id", referencedColumnName =  "id" ,nullable = false)
	private Employer employer;

	@ManyToOne(targetEntity = JobTitle.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "job_title_id", referencedColumnName =  "id" ,nullable = false)
	private JobTitle jobTitle;
	
	@ManyToOne(targetEntity = City.class ,fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="city_id", referencedColumnName =  "id" ,nullable = false)
	private City city;

}
