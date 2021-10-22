package ros.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errand {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private Boolean active;
	
	@Column(nullable = false) 
	private Boolean paymentstatus;
	
	@Column(nullable = false) 
	private Boolean orderstatus;
	
	@OneToOne
	private Basket basket;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Desk desk;
}
