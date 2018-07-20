package org.awakening.javashopping.controller;

import org.awakening.javashopping.exception.ProductNotFoundException;
import org.awakening.shoppingbackend.dao.CategoryDAO;
import org.awakening.shoppingbackend.dao.ProductDAO;
import org.awakening.shoppingbackend.dto.Category;
import org.awakening.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	// home Page
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("userClickHome", true);
		mv.addObject("categories", categoryDAO.list()); // ALl category located at Left sidebar
		return mv;
	}
	
	// about Page
	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About US");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	 
	// contact Page
		@RequestMapping(value = "/contact")
		public ModelAndView contact() {
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title", "Contact US");
			mv.addObject("userClickContact", true);
			return mv;
		}
	
	// ListProduct Page
	@RequestMapping(value = "/listProducts")
	public ModelAndView showAllProduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All products");
		mv.addObject("userClickAllProducts", true);
		mv.addObject("categories", categoryDAO.list());
		return mv;
	}
	
	// Load all products and based on category	
		@RequestMapping(value = "/show/category/{id}/products")
		public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
			ModelAndView mv = new ModelAndView("page");
			
			// categoryDAO to fetch a single category
			Category category = categoryDAO.get(id);
			mv.addObject("title", category.getName());
			
			// passing the list of categories
			mv.addObject("categories", categoryDAO.list());
			// passing a single category
			mv.addObject("category", category);
			
			mv.addObject("userClickCategoryProducts", true);
			return mv;
		}
		
		
		// Views Single Product
		
		@RequestMapping(value="/show/{id}/product", method = RequestMethod.GET)
		public ModelAndView SingleProduct(@PathVariable int id) throws ProductNotFoundException
		{
			ModelAndView mv = new ModelAndView("page");
			
			Product product = productDAO.get(id);
			
			if (product == null) throw new ProductNotFoundException();
			
			// update view count
			product.setViews(product.getViews()+1);
			
			productDAO.update(product);
			
			// add variable to view
			mv.addObject("title", product.getName());
			mv.addObject("product", product);
			
			// turn on flag
 			mv.addObject("userClickShowProduct", true);
			
			return mv;
		}


}
