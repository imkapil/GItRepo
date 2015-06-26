package com.sogeti.coe.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

import com.sogeti.coe.model.Category;
import com.sogeti.coe.service.CategoryService;

@Component
public class CategoryEditor extends PropertyEditorSupport {
	
	// Do not use @Autowired.
    // Use dependency injection in class constructor.
    private final CategoryService categoryService;
     
    public CategoryEditor() {
        this.categoryService = null;
    }
     
    //This constructor will be used to inject the categoryService.
    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
     
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Find a category by its categoryId from text
        Category category = categoryService.findById(Long.parseLong(text));
        setValue(category);
    }   

}
