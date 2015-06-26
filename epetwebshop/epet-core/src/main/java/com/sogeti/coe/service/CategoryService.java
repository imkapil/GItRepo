package com.sogeti.coe.service;

import java.util.List;

import com.sogeti.coe.model.Category;

public interface CategoryService {

	public void addCategory(Category category);
	 public List<Category>findAll();
	public Category findById(Long categoryId);
	public void editCategory(Category category, Long categoryId);
	public void removeCategory(Long categoryId);
	

}
