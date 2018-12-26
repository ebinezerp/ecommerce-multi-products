package b190172.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import b190172.backend.config.HibernateConfig;
import b190172.backend.dao.SellerDao;
import b190172.backend.model.Seller;
import b190172.backend.model.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= HibernateConfig.class)
public class SellerTest {
	
	
	private Seller seller;
	private User user;
	@Autowired
	private SellerDao sellerDao;
	
	
	@BeforeEach
	public void setup() {
		
		user=new User();
		user.setFirstName("ebinezer");
		user.setLastName("perumala");
		user.setEmail("ebinezer@gmail.com");
		user.setMobile("9494216610");
		user.setPassword("ebinezer");
		user.setRole("seller");
		user.setEnable(true);
		
		
		seller = new Seller();
		
		seller.setCompanyName("My Seller Company");
		seller.setLisence("ABCD1234");
		seller.setLisenceEndDate(new Date());
		seller.setUser(user);
	}
	
	
	@Test
	public void testAddSeller() {
		
		assertTrue(sellerDao.add(seller));
	}
	
	
	@Test
	public void testAddSellerFailure1() {
		seller.setUser(null);
		assertFalse(sellerDao.add(seller));
	}
	
	@Test
	public void testAddSellerFailure2() {
		seller.getUser().setUserId(7);
		assertFalse(sellerDao.add(seller));
	}
	
	
	
	@Test
	public void testGetSeller() {
		sellerDao.add(seller);
		assertEquals(seller.getCompanyName(),sellerDao.get(seller.getSellerId()).getCompanyName());
		assertEquals(seller.getUser().getEmail(),sellerDao.get(seller.getSellerId()).getUser().getEmail());
	}
	
	
	@Test
	public void testGetSellerFailure() {
		assertNull(sellerDao.get(seller.getSellerId()));
	}
	
	
	@Test
	public void testSellerUpdate() {
		sellerDao.add(seller);
		seller=sellerDao.get(seller.getSellerId());
		seller.getUser().setEmail("newemail@mail.com");
		assertTrue(sellerDao.update(seller));
	}
	
	
	
	@AfterEach
	public void tearDown() {
		if(sellerDao.get(seller.getSellerId())!=null) {
			sellerDao.delete(seller);
		}
		
	}

}
