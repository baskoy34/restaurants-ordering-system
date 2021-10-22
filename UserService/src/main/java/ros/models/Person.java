package ros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;
	
	@Column(length = 75,nullable = false) 
	private String surname;
	
	@Column(length = 150) 
	private String address;
	
	@Column(length = 15) 
	private String phone;
	
	@Column(length = 150,nullable = false) 
	private String email;
	
	@Column(length = 150) 
	private Integer salary;
	
	
	
}
