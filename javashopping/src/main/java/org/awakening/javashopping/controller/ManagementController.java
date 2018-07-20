package org.awakening.javashopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.awakening.javashopping.util.FIleUploadUtility;
import org.awakening.javashopping.validator.ProductValidator;
import org.awakening.shoppingbackend.dao.CategoryDAO;
import org.awakening.shoppingbackend.dao.ProductDAO;
import org.awakening.shoppingbackend.dto.Category;
import org.awakening.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method = RequestMethod.GET)
	public ModelAndView showManageProduct (@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product product = new Product();
		product.setSupplierId(244);      
		product.setActive(true);
		mv.addObject("product", product);
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message", "Product Submitted Successfully!");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mproduct, BindingResult results, Model model, HttpServletRequest request) {
		
		
		new ProductValidator().validate(mproduct, results);
		
		// Check if there is any error
		if(results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failed for Product Submission :(");
			return "page";
		}
		
		logger.info(mproduct.toString());
		// create a new product
		productDAO.add(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals("")) {
			
			FIleUploadUtility.uploadFile(request, mproduct.getFile(), mproduct.getCode());
			
		}
		 
		return "redirect:/manage/products?operation=product";
	}
	// Get list categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories () {
		return categoryDAO.list();
	}
}
