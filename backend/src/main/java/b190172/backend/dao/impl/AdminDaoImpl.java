package b190172.backend.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import b190172.backend.dao.AdminDao;
import b190172.backend.model.AdminDetails;

@Repository("adminDao")
@Transactional
public class AdminDaoImpl implements AdminDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public AdminDetails login(String employeeId, String password) {
		try {
			return sessionFactory.getCurrentSession().createQuery("select a from AdminDetails a inner join a.user u where a.employeeId=:empId and u.password=:pass",AdminDetails.class)
			.setParameter("empId", employeeId)
			.setParameter("pass", password)
			.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public AdminDetails validateEmail(String email, String employeeCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateRandomPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}
