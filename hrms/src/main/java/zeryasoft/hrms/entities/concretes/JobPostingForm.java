package zeryasoft.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_posting_forms")
public class JobPostingForm {
	@Id
	@Column(name="id", updatable = false,nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	 * @Column(name="city_id") private int cityId;
	 */
	
	/*
	 * @Column(name="job_title_id") private int jobTitleId;
	 */
	
	@Column(name="definition")
	private String definition;
	
	@Column(name="min_salary")
	private String  minSalary;
	
	@Column(name="max_salary")
	private String  maxSalary;
	
	@Column(name="number_of_needs")
	private int numberOfNeeds;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_activeted")
	private boolean isActivated;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private City cityId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "job_title_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private JobTitle jobTitleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employer_id", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Employer employerId;
	
}
