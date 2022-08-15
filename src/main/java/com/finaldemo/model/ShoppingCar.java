package com.finaldemo.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ShoppingCar")
public class ShoppingCar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shoppingCarId;
	
	private Integer quantity;
	
	private Integer unitPrice;
	
	private Integer totalPrice;
	
	@OneToOne(mappedBy = "ShoppingCar")
	private Users user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCar", cascade = CascadeType.ALL)
	private Set<Product> products = new LinkedHashSet<Product>(); 
	
	public ShoppingCar() {
	}

	public Integer getShoppingCarId() {
		return shoppingCarId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public Users getUser() {
		return user;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setShoppingCarId(Integer shoppingCarId) {
		this.shoppingCarId = shoppingCarId;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	
}
