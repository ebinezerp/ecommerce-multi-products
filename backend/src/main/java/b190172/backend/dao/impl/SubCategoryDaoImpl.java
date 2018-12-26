package b190172.backend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.SubCategory;

@Repository
@Transactional
public class SubCategoryDaoImpl implements SubCategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addSubCategory(SubCategory subCategory) {
		try {
			sessionFactory.getCurrentSession().save(subCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}

	@Override
	public boolean updateSubCategory(SubCategory subCategory) {
		try {
			sessionFactory.getCurrentSession().update(subCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}

	@Override
	public boolean deleteSubCategory(SubCategory subCategory) {
		try {
			sessionFactory.getCurrentSession().delete(subCategory);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}

	@Override
	public SubCategory get(int subCategoryId) {
		try {
			return sessionFactory.getCurrentSession().get(SubCategory.class,subCategoryId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<SubCategory> getSubCategories() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From SubCategory",SubCategory.class)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
