package com.sogeti.coe.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sogeti.coe.model.Category;
import com.sogeti.coe.model.Product;
import com.sogeti.coe.service.CategoryService;
import com.sogeti.coe.service.ProductService;

@Controller
public class ProductController {
	@Autowired
   private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(
				categoryService));
	}

	// to get the list page 
	@RequestMapping(value = "/product/", method = RequestMethod.GET)
	public ModelAndView productHome() {

	
		ModelAndView mav = new ModelAndView("/product/list");

		mav.addObject("productsList", productService.findAll());
		
		return mav;
	}
	
	// getting the product Add form

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public ModelAndView productAddForm() {

		
		ModelAndView mav = new ModelAndView("/product/add");
		mav.addObject("productBean", new Product());
		mav.addObject("categories", categoryService.findAll());
		return mav;
	}

	
	// Saving the product detail
	
	@RequestMapping(value="/product/addProductConfirm", method=RequestMethod.POST)
    public ModelAndView productAddConfirm(@Valid @ModelAttribute("productBean") Product product, BindingResult result) {
    
      if(result.hasErrors()){
    	  ModelAndView mav = new ModelAndView("/product/add");
    	  mav.addObject("productBean",  product);
  		mav.addObject("categories", categoryService.findAll());
  		 return mav;
      }
       ModelAndView mav = new ModelAndView("redirect:/product/");
        productService.addProduct(product);
         
        return mav;

}
	// Edit the product detail
	
	@RequestMapping(value="/product/edit/{productId}", method=RequestMethod.GET)
	public ModelAndView productEditForm(@PathVariable Long productId) {
	   
	    ModelAndView mav = new ModelAndView("/product/edit");
	    Product productEdit = productService.findById(productId); 
	    mav.addObject("categories", categoryService.findAll());
	    mav.addObject("productBean", productEdit);
	 
	    return mav;
	}
	
	//  saved Edit detail of product
	@RequestMapping(value="/product/edit/editProductConfirm", method=RequestMethod.POST)
	public ModelAndView productEditConfirm(@Valid @ModelAttribute("productBean") Product product, BindingResult result) {
	 
	 if(result.hasErrors()){
		    ModelAndView mav = new ModelAndView("/product/edit");
		    mav.addObject("categories", categoryService.findAll());
		    mav.addObject("productBean", product);
           return mav;
	 
	 }
		// set view: redirect to /product/
	    ModelAndView mav = new ModelAndView("redirect:/product/");
	 
	    // Update Product from edit form
	    productService.editProduct(product, product.getProductId());
	 
	    return mav;
	}
	
	//Remove the product from List
	
	@RequestMapping(value="/product/delete/{productId}", method=RequestMethod.GET)
	public ModelAndView productRemoveConfirm(@PathVariable Long productId) {
	 
	    ModelAndView mav = new ModelAndView("redirect:/product/");
	 
	    productService.removeProduct(productId);
	 
	    return mav;
	}

	
}
