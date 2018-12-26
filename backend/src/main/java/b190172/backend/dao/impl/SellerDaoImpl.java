package b190172.backend.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.SellerDao;
import b190172.backend.model.Seller;
import b190172.backend.model.User;

@Repository("sellerDao")
@Transactional
public class SellerDaoImpl implements SellerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean add(Seller seller) {
		try {
			if (seller.getUser() != null) {
				if ((seller.getUser().getUserId() != 0 && getUser(seller.getUser().getUserId()) != null)
						|| seller.getUser().getUserId() == 0) {
					sessionFactory.getCurrentSession().save(seller);
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}

		} catch (HibernateOptimisticLockingFailureException e) {
			return false;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Seller seller) {
		try {
			sessionFactory.getCurrentSession().update(seller);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Seller seller) {
		try {
			sessionFactory.getCurrentSession().delete(seller);
			return true;
		} catch (Exception e) {
			sessionFactory.getCurrentSession().clear();
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Seller get(int sellerId) {
		try {
			return sessionFactory.getCurrentSession().get(Seller.class, sellerId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Seller> get() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Seller", Seller.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Seller> getActiveSeller() {

		try {
			return sessionFactory.getCurrentSession()
					.createQuery("From Seller where user_userId in (select userid from user where enable=true)",
							Seller.class)
					.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private User getUser(int userId) {
		try {
			return sessionFactory.getCurrentSession().createQuery("From User where userId=:userId", User.class)
					.setParameter("userId", userId).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
