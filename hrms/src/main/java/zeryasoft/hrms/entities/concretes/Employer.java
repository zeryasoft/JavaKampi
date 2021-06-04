package zeryasoft.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Employer  extends User{
	
	@NotBlank(message="Şirket İsmi Alanı Boş Olamaz")
	@Column(name="company_name")
	private String companyName;
	
	@NotBlank(message="Web Sitesi Alanı Boş Olamaz")
	@Column(name="web_address")
	private String webAddress;
	
	@NotBlank(message="Telefon Numarası Alanı Boş Olamaz")
	@Column(name="phone_number")
	private String phoneNumber;
		
	@OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
	private List<JobPosting> jobPostings;
	
}
