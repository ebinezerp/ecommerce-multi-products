package b190172.backend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.AttributeDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.Attribute;
import b190172.backend.model.SubCategory;

@Repository
@Transactional
public class AttributeDaoImpl implements AttributeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SubCategoryDao subCategoryDao;

	@Override
	public boolean addAttribute(Attribute attribute) {
		try {
			if (attribute.getSubCategories() != null && attribute.getSubCategories().size() > 0) {
				if (isAllSubCategoriesExisted(attribute.getSubCategories())) {
					sessionFactory.getCurrentSession().save(attribute);
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}

	@Override
	public boolean updateAttribute(Attribute attribute) {
		try {
			if (attribute.getSubCategories() != null && attribute.getSubCategories().size() > 0) {
				if (isAllSubCategoriesExisted(attribute.getSubCategories())) {
					sessionFactory.getCurrentSession().merge(attribute);
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			sessionFactory.getCurrentSession().clear();
			return false;
		}
	}

	@Override
	public boolean deleteAttribute(Attribute attribute) {
		try {
			sessionFactory.getCurrentSession().delete(attribute);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Attribute get(long attributeId) {
		try {
			return sessionFactory.getCurrentSession().get(Attribute.class, attributeId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public List<Attribute> getAttributes() {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Attribute",Attribute.class)
			.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private boolean isAllSubCategoriesExisted(List<SubCategory> subCategories) {
		for (SubCategory subCategory : subCategories) {
			if (subCategoryDao.get(subCategory.getSubCategoryId()) == null) {
				return false;
			}
		}
		return true;
	}

}
