package com.sogeti.coe.repository;

import java.util.List;

import com.sogeti.coe.model.Category;

public interface CategoryRepository {
	
	public void addCategory(Category category);
	
	public List<Category>findAll();

	public void editCategory(Category category, Long categoryId);

	public Category findById(Long categoryId);
	public void removeCategory(Long categoryId);
}
