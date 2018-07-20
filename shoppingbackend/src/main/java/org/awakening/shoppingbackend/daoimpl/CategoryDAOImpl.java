package org.awakening.shoppingbackend.daoimpl;

import java.util.List;

import org.awakening.shoppingbackend.dao.CategoryDAO;
import org.awakening.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	// MEMORIED TESTING
	
//	private static List<Category> categories = new ArrayList<Category>();
//	
//	static {
//		
//		Category category = new Category();
//		
//		// adding first category
//		category.setId(1);
//		category.setName("Smart Phone");
//		category.setDescription("This is some description for Smart Phone Product Line!");
//		category.setImageURL("CAT_1.png");
//		
//		categories.add(category);
//		
//		// second category
//		category = new Category();
//		
//		// adding second category
//		category.setId(2);
//		category.setName("Smart TV");
//		category.setDescription("This is some description for Smart Television Product Line!");
//		category.setImageURL("CAT_2.png");
//		
//		categories.add(category);
//		
//		// adding thỉd category
//		category = new Category();
//				category.setId(3);
//				category.setName("Cooker");
//				category.setDescription("This is some description for Korean Cooker Product Line!");
//				category.setImageURL("CAT_2.png");
//				
//				categories.add(category);
//		
//	}
	// END MEMORIED TESTING
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		//return categories;
		
		try {
			
			// Category is the name of Entity Object
			String SelectOnlyActiveCategory = "FROM Category WHERE active = :active";
			
			//@SuppressWarnings("rawtypes")
			Query<Category> qr = sessionFactory.getCurrentSession().createQuery(SelectOnlyActiveCategory);
			
			qr.setParameter("active", true);
			
			return qr.getResultList();
			
			
		}catch(Exception ex) {
			
			ex.printStackTrace();
			return null;
			
		}
	}

	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		// enhanced for loop
//		for(Category category : categories) {
//			if (category.getId() == id)
//				return category;
//		}
		try {
			
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		
		try {
			// add new category to the DATABASE TABLE
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch (Exception ex) {
			
			
			ex.printStackTrace();
			
			return false;
			
		}
	}

	@Override
	public boolean update(Category category) {
		// TODO Auto-generated method stub
		try {
			
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean detele(Category category) {
		// TODO Auto-generated method stub
		
		
		// turn on flag
		category.setActive(false);
		
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
