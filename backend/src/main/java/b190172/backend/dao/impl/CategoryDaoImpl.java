package b190172.backend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.CategoryDao;
import b190172.backend.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Category get(int categoryId) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, categoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public List<Category> getCategories() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Category",Category.class)
			.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
