package org.awakening.shoppingbackend.dao;

import java.util.List;

import org.awakening.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	
	boolean add(Category category);
	
	List<Category> list();
	
	Category get(int id);
	
	boolean update(Category category);
	
	boolean detele(Category category);
}
