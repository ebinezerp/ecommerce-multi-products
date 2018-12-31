package b190172.backend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.ProductDao;
import b190172.backend.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Product getProduct(long productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getProducts() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Product",Product.class)
			.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
