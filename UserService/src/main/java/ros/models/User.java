package ros.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String username;
	
	@Column(length = 75,nullable = false) 
	private String password;
	
	@Column(length = 75,nullable = false) 
	private Boolean active;
	
	@OneToOne
	private Person person;

	@ManyToMany
	private List<Role> roles;
	
	@ManyToOne
	@JoinColumn
	private Store store;
	
}
