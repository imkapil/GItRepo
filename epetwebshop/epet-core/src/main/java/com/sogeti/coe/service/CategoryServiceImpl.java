package com.sogeti.coe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sogeti.coe.model.Category;
import com.sogeti.coe.repository.CategoryRepository;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		System.out.println("Inside Service Impl");
		categoryRepository.addCategory(category);

	}

	public List<Category> findAll() {
		System.out.println("Inside Service Impl in Find all Method");
		return categoryRepository.findAll();
	}

	@Override
	public Category findById(Long categoryId) {
		return categoryRepository.findById(categoryId);
	}

	@Override
	public void editCategory(Category category, Long categoryId) {
		categoryRepository.editCategory(category, categoryId);

	}

	@Override
	public void removeCategory(Long categoryId) {
		categoryRepository.removeCategory(categoryId);

	}

}
