package org.awakening.shoppingbackend.test;

import org.awakening.shoppingbackend.dao.ProductDAO;
import org.awakening.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init () {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.awakening.shoppingbackend");
		
		context.refresh();
		
		productDAO = (ProductDAO)context.getBean("productDAO");
		
	}
	
	@Test
	public void TestFullOperationWithProduct () 
	{
		// add Region
//		product = new Product();
//		
//		product.setName("Sony Xperia XZ Dual");
//		product.setBrand("Sony");
//		product.setQuantity(44);
//		product.setDescription("MidRange from Sony 2017 with New Design");
//		product.setUnitPrice(352);
//		product.setCategoryId(149);
//		product.setSupplierId(245);
//		
//		assertEquals("Successfully added new smart phone product", true, productDAO.add(product));
		
		// fetch single
		
//		product = new Product();
//		
//		product = productDAO.get(1023);
//		
//		assertEquals("Successfully fetch single product", "PRODUCT-9FF2509FAB", product.getCode());
		
		// update single
		
//		product = new Product();
//		product = productDAO.get(1023);
//		product.setPurchases(1000);
//		assertEquals("Successfully updated single record", true, productDAO.update(product));
		
		
		// Delete record
		
//		product = new Product();
//		product = productDAO.get(1023);
//		product.setActive(false);
//		
//		assertEquals("Successfully delete a record", true, productDAO.delete(product));
		
		// fetch list based on criteria
		
		assertEquals("Successfully fetch expected list", 0, productDAO.listActiveProducts().size());	
		
	}
	
	
	
}
