package zeryasoft.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable = false,nullable = false)
	private int id;
	
	@NotNull
	@Email
	@Column(name="city_name")
	private String cityName;
	
	/*
	 * @OneToMany(targetEntity = JobPostingForm.class, mappedBy = "id",
	 * orphanRemoval = false, fetch = FetchType.LAZY) private Set<JobPostingForm>
	 * jobPostingForms;
	 */
}
