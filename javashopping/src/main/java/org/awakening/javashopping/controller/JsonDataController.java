package org.awakening.javashopping.controller;

import java.util.List;

import org.awakening.shoppingbackend.dao.ProductDAO;
import org.awakening.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	
	
	@Autowired
	private ProductDAO productDAO;
	
	// get all product   
 	@RequestMapping(value = "/all/products", method = RequestMethod.GET)
 	@ResponseBody
	public List<Product> getAllProducts () {
		
		return productDAO.listActiveProducts();
 	}
 	
 // admin get all product  
  	@RequestMapping(value = "/admin/all/products", method = RequestMethod.GET)
  	@ResponseBody
 	public List<Product> getAllProductsForAdmin () {
 		
 		return productDAO.list();
  	}
 	
 	// get based on category
 	@RequestMapping(value = "/category/{id}/products", method = RequestMethod.GET)
 	@ResponseBody
	public List<Product> getAllProductsByCategory (@PathVariable int id) {
		
		return productDAO.listActiveProductsByCategory(id);
 	}
}
