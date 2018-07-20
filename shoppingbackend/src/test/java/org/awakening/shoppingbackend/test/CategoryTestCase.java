package org.awakening.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.awakening.shoppingbackend.dao.CategoryDAO;
import org.awakening.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private Category category;
	
	@BeforeClass
	public static void init () {
		
		context = new AnnotationConfigApplicationContext();
		
		context.scan("org.awakening.shoppingbackend");
		
		context.refresh();
		
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		
	}
	
	// add case
//	@Test
//	public void testAddCategory() {
//		category  = new Category();
//		
//		// adding first category
//		category.setName("Wearable");
//		category.setDescription("This is some description for Wearable Products Line!");
//		category.setImageURL("CAT_4.png");
//		
//		assertEquals("Successfully added a new category into the table =))", true, categoryDAO.add(category));
//				
//	}
	
//	// get single case
//	@Test
//	public void TestGetSingleCategory() {
////		Category category = new Category();
//		
//		assertEquals("Successfully get specify category based on Ids","Not Wearable", categoryDAO.get(1).getName());
//	}
	
	// update single category
//	@Test
//	public void TestUpdateSingleCategory() {
//		
//		category = categoryDAO.get(1);
//		
//		category.setName("Smart Watch");
//		
//		assertEquals("Successfully updated name to Smart Watch", true, categoryDAO.update(category));
//		
//	}
	
	// Detele single record
//	@Test
//	public void TestDeleteSingleCategory() {
//		
//		category = categoryDAO.get(1);
//		
//		
//		assertEquals("Successfully updated flag to unavailable", true, categoryDAO.detele(category));
//		
//	}
	
	// Get List Record
	
//	@Test
//	
//	public void TestGetListActiveCategory() {
//		assertEquals("Successfully get expected list", 2, categoryDAO.list().size());
//	}
	
	// Test All
	@Test
	
	public void TestFullOperationWithCategory() {
		// add Region
		category = new Category();
		category.setName("Hande-Made");
		category.setDescription("This is all about hand-made product =))");
		category.setImageURL("not_exist_url");
		
		assertEquals("Successfully added new category", true, categoryDAO.add(category));
		
		// update Region
		category = categoryDAO.get(146);
		category.setName("Handicraft");
		category.setDescription("This is all about Handicraft product =))");
		category.setImageURL("till_non_exist_url");
		
		assertEquals("Successfully updated", true, categoryDAO.update(category));
		
		// delete Region
		
		category = categoryDAO.get(146);
		
		assertEquals("Successfully deleted", true, categoryDAO.detele(category)); 
		
		// fetch all active Region
		
		assertEquals("Successfully got the expceted List", 2, categoryDAO.list().size());
	}
	
	
}
