package org.awakening.shoppingbackend.daoimpl;

import java.util.List;

import org.awakening.shoppingbackend.dao.ProductDAO;
import org.awakening.shoppingbackend.dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("productDAO")
@Transactional
public class ProductDAOlmpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> list() {
		try {
			
			return sessionFactory
						.getCurrentSession()
							.createQuery("FROM Product", Product.class)
								.getResultList();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean add(Product product) {
		try {
			
			sessionFactory
						.getCurrentSession()
							.persist(product);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		
		try {
				sessionFactory
					.getCurrentSession()
						.update(product);
			
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		
		try {
			
				product.setActive(false);
				return update(product);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProduct = "FROM Product WHERE active = :active";
		
//		Query<Product> query; 
				
		return sessionFactory
							.getCurrentSession()
								.createQuery(selectActiveProduct, Product.class)
									.setParameter("active", true)
										.getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		
		
		String selectActiveProductByCategory = "FROM Product WHERE active = :active and categoryId = :categoryId";
		
		return sessionFactory
						.getCurrentSession()
							.createQuery(selectActiveProductByCategory, Product.class)
								.setParameter("active", true)
								.setParameter("categoryId", categoryId)
									.getResultList();
	}
	
	@Override
	public List<Product> getLatestActiveProducts(int limit) {
		
		String query = "FROM Product WHERE active = :active ORDER BY id";
		return sessionFactory
				.getCurrentSession()
					.createQuery(query, Product.class)
						.setParameter("active", true)
						.setFirstResult(0)
						.setMaxResults(limit)
							.getResultList();
	}

}
