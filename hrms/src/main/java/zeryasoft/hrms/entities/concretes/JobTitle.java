package zeryasoft.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable = false,nullable = false)
	private int id;
	
	@NotBlank(message="Başlık Alanı Boş olamaz")
	@Column(name="title")
	private String title;
	
	 @OneToMany(mappedBy = "jobTitle", cascade = CascadeType.ALL) 
	 private List<JobPosting>jobPostings;
	 
}
