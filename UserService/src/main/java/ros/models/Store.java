package ros.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Store {

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
	private Boolean active;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Company company;
	
	@OneToMany(mappedBy = "store")
	private List<Desk> desks;
	
	@OneToMany(mappedBy = "store")
	private List<Category> categoryies;
	
	@OneToMany(mappedBy = "store")
	private List<User> users;
}
