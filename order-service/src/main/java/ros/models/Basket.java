package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@AllArgsConstructor
@NoArgsConstructor
public class Basket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private double totalPrice;
	
	@Column(nullable = false) 
	private double totalVat;


	@Column(nullable = false)
	private int totalItem;
	
	@OneToMany(mappedBy = "basket")
	private List<BasketProduct> basketProducts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalVat() {
		return totalVat;
	}

	public void setTotalVat(double totalVat) {
		this.totalVat = totalVat;
	}

	public List<BasketProduct> getBasketProducts() {
		return basketProducts;
	}

	public void setBasketProducts(List<BasketProduct> basketProducts) {
		this.basketProducts = basketProducts;
	}

	public int getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(int totalItem) {
		this.totalItem = totalItem;
	}
}
