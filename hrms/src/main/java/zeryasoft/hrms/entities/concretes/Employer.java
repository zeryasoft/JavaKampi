package zeryasoft.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(name="employers")
public class Employer  extends User{
	
	@Column(name="company_name")
	private String CompanyName;
	
	@Column(name="web_address")
	private String WebAddress;
	
	@Column(name="phone_number")
	private String PhoneNumber;
	
	
	/*
	 * @OneToMany(targetEntity = JobPostingForm.class, mappedBy =
	 * "employer_id",orphanRemoval = false, fetch = FetchType.LAZY) private
	 * Set<JobPostingForm> jobPostingForms;
	 */
	 
}
