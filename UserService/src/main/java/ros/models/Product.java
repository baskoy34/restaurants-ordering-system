package ros.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;
	
	@Column(length = 500,nullable = false) 
	private String information;
	
	@Lob
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private double price;

	@Column(nullable = false)
	private boolean active;
	
	@Column(nullable = false)
	private double vat;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<BasketProduct> basketProducts;
}
