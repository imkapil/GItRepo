package com.sogeti.coe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sogeti.coe.model.Product;
import com.sogeti.coe.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
	private ProductRepository productRepository;
	
	@Override
	public void addProduct(Product product) {
		productRepository.addProduct(product);	
		
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		 return productRepository.findAll();
	}

	@Override
	public Product findById(Long productId) {
		
		return productRepository.findById(productId);
		
	}

	@Override
	public void editProduct(Product product, Long productId) {
		productRepository.editProduct(product,productId);
		
	}

	@Override
	public void removeProduct(Long productId) {
		productRepository.removeProduct(productId);
		
	}

}
