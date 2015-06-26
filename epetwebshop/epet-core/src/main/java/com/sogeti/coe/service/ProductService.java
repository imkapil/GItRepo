package com.sogeti.coe.service;

import java.util.List;

import com.sogeti.coe.model.Product;

public interface ProductService {

	public void addProduct(Product product);

	public List<Product> findAll();

	public Product findById(Long productId);

	public void editProduct(Product product, Long productId);

	public void removeProduct(Long productId);
}
