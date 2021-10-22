package ros.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BasketProduct extends BaseEntityModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false) 
	private Integer piece;
	
	@ManyToOne
	@JoinColumn(name="productId",nullable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="basketId",nullable = false)
	private Basket basket;

	public BasketProduct(Integer piece, Product product, Basket basket) {
		this.piece = piece;
		this.product = product;
		this.basket = basket;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Integer getPiece() {
		return piece;
	}

	public void setPiece(Integer piece) {
		this.piece = piece;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}
}
