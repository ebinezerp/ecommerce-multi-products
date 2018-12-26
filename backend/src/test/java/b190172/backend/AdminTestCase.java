package b190172.backend;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import b190172.backend.config.HibernateConfig;
import b190172.backend.dao.AdminDao;
import b190172.backend.model.AdminDetails;

@SpringJUnitConfig(classes=HibernateConfig.class)
public class AdminTestCase {
	
	@Autowired
	private AdminDao adminDao;
	
	@Test
	public void testAdminLogin() {
		
	   AdminDetails adminDetails=adminDao.login("ADMIN@123","admin");
	   
	   assertTrue(adminDetails.getEmployeeId().equals("ADMIN@123"));
	   assertTrue(adminDetails.getUser().getPassword().equals("admin"));
	}
	
	@Test
	public void testAdminLoginFailure() {
		
	  assertNull(adminDao.login("ADMIN@123","admina"));
	   
	 
	}

}
