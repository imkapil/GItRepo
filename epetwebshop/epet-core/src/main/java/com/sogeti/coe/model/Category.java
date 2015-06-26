package com.sogeti.coe.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Category")
public class Category  {
	
	@Id
	@GeneratedValue
	@Column(name="Category_Id")
	private Long categoryId;
	
	@Column(name="Category_Name")
	@NotEmpty
	private String categoryName;
	
	@Column(name="Category_Description")
	private String categoryDescription;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Product>productList;
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}
	
	public Long getCategoryId() {
		return categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

}
