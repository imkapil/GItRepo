package com.sogeti.coe.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sogeti.coe.model.Category;
import com.sogeti.coe.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	 private CategoryService categoryService;

	// method used for getting the list of Category
	@RequestMapping(value = "/category/", method = RequestMethod.GET)
	public ModelAndView categoryHome() {

		ModelAndView mav = new ModelAndView("/category/list");
		mav.addObject("categories", categoryService.findAll());
		return mav;
	}

	// method used for adding Category
	@RequestMapping(value = "/category/add", method = RequestMethod.GET)
	public ModelAndView categoryAddForm() {

		ModelAndView mav = new ModelAndView("/category/add");
		mav.addObject("categoryBean", new Category());

		return mav;
	}

	// method used for saving Category
	@RequestMapping(value = "/category/addCategoryConfirm", method = RequestMethod.POST)
	public ModelAndView categoryAddConfirm( @Valid @ModelAttribute("categoryBean") Category category
			,BindingResult result) {
		// if it has any error 
		if(result.hasErrors()){
			 ModelAndView mav = new ModelAndView("/category/add");
			 mav.addObject("categoryBean", category);
			 return mav;
		}
		 				
		categoryService.addCategory(category);
		return new ModelAndView("redirect:/category/");
		 
	}

	// method used for Edit Category

	@RequestMapping(value = "/category/edit/{categoryId}", method = RequestMethod.GET)
	public ModelAndView categoryEditForm(@PathVariable Long categoryId) {

		ModelAndView mav = new ModelAndView("/category/edit");
		Category categoryEdit = categoryService.findById(categoryId);
		mav.addObject("categoryBean", categoryEdit);

		return mav;
	}

	// method used for saved Edit Category

	@RequestMapping(value = "/category/edit/editCategoryConfirm", method = RequestMethod.POST)
		public ModelAndView categoryEditConfirm( @ Valid @ModelAttribute("categoryBean") Category category, BindingResult result) {
			 if(result.hasErrors())
			 {
					ModelAndView mav = new ModelAndView("/category/edit");
					mav.addObject("categoryBean", category);
					return mav;
			 }

			ModelAndView mav = new ModelAndView("redirect:/category/");
					// Update Category from edit form
			categoryService.editCategory(category, category.getCategoryId());

			return mav;
		}

	// method used for saved remove Category
	@RequestMapping(value = "/category/delete/{categoryId}", method = RequestMethod.GET)
	public ModelAndView categoryRemoveConfirm(@PathVariable Long categoryId) {

		ModelAndView mav = new ModelAndView("redirect:/category/");

		categoryService.removeCategory(categoryId);

		return mav;
	}

}
