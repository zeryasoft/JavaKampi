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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable = false,nullable = false)
	private int id;
		
	@Column(name="university_id")
	private int universityId;

	@Column(name="school_name")
	@NotBlank(message="Boş Geçilemez")
	private String SchoolName;

	@Column(name="department")
	@NotBlank(message="Boş Geçilemez")
	private String department;

	@Column(name="start_year")
	private int startYear;

	@Column(name="graduation_year")
	private int graduationYear;

	@Column(name="added_date")
	private Date addedDate;
	

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id", referencedColumnName =  "id" ,nullable = false)
	private Resume resume;
	
	@ManyToOne(targetEntity = GraduationStatus.class)
	@JoinColumn(name = "degree_id", referencedColumnName =  "id" ,nullable = false)
	private GraduationStatus graduationStatus;
	
}
