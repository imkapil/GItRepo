package com.sogeti.coe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue
	private Long productId;

	@NotEmpty
	@Column(name="Product_Name")
	private String productName;
	
	@Column(name="Product_Description")
	private String productDescription;

	@NotNull
	@Column( name="Product_Price")
	private double productPrice;

	@Range(min = 1, max = 1000)
	@Column( name="Product_Stock")
	private int productStock;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	public Category getCategory() {
		return category;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public Long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + ", productStock="
				+ productStock + ", category=" + category + "]";
	}

}
