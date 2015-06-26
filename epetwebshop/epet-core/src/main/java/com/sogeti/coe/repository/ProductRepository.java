package com.sogeti.coe.repository;

import java.util.List;

import com.sogeti.coe.model.Product;

public interface ProductRepository {

	public void addProduct(Product product);

	public List<Product> findAll();

	public void editProduct(Product product, Long productId);

	public Product findById(Long productId);

	public void removeProduct(Long productId);

}
