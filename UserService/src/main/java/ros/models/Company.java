package ros.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;
	
	@Column(length = 150,nullable = false) 
	private String address;
	
	@Column(length = 15,nullable = false) 
	private String phone;
	
	@Column(nullable = false) 
	private Integer storeNumber;
	
	@Temporal(TemporalType.DATE)
    private Date registerDAte;
	
	@Temporal(TemporalType.DATE)
    private Date memberEndDate;
	
	@Column(nullable = false) 
	private Boolean active;
	
	@OneToMany(mappedBy = "company")
	private List<Store> stores;
	
	@OneToOne
	private CompanyCustomize companyCustomize;
	
}
