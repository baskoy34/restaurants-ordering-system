package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Errand extends BaseEntityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private Boolean active;
	
	@Column(nullable = false) 
	private Boolean paymentstatus;
	
	@Column(nullable = false) 
	private OrderStatus orderstatus;
	
	@OneToOne
	private Basket basket;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Desk desk;
}
