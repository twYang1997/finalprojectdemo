package com.finaldemo.model;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	private String productName;
	
	private Integer productPrice;
	
	private String productImg;
	
	private Integer buyCount;
	
	private String productContext;
	
	private Date productDate;
	
	private Integer productStatus;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name="fk_user_id", referencedColumnName = "userId")
	private Users user;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = ShoppingCar.class)
	@JoinColumn(name="fk_shoppingCarId_id", referencedColumnName = "shoppingCarId")
	private ShoppingCar shoppingCar;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetail = new LinkedHashSet<OrderDetail>(); 
	
	public Product() {
	}

	public Integer getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getProductPrice() {
		return productPrice;
	}

	public String getProductImg() {
		return productImg;
	}

	public Integer getBuyCount() {
		return buyCount;
	}

	public String getProductContext() {
		return productContext;
	}

	public Date getProductDate() {
		return productDate;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}

	public void setProductContext(String productContext) {
		this.productContext = productContext;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public ShoppingCar getShoppingCar() {
		return shoppingCar;
	}

	public void setShoppingCar(ShoppingCar shoppingCar) {
		this.shoppingCar = shoppingCar;
	}

	public Integer getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(Integer productStatus) {
		this.productStatus = productStatus;
	}
	
}
