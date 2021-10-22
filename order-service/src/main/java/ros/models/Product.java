package ros.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 75,nullable = false) 
	private String name;



	@Column(length = 500,nullable = false)
	private String information;



	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private double price;
	
	@Column(nullable = false)
	private double vat;

	private String category;

	public Product(String name, String information, String image, double price, double vat, String category) {
		this.name = name;
		this.information = information;
		this.image = image;
		this.price = price;
		this.vat = vat;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
