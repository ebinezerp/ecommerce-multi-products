package b190172.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import b190172.backend.config.HibernateConfig;
import b190172.backend.dao.AttributeDao;
import b190172.backend.dao.CategoryDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.Attribute;
import b190172.backend.model.Category;
import b190172.backend.model.SubCategory;

@SpringJUnitConfig(classes= {HibernateConfig.class})
public class AttributeTestCase {

	@Autowired
	private AttributeDao attributeDao;
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	private Category category;
	
	private List<SubCategory> subCategories;
	
	
	private Attribute attribute;
	
	
	@BeforeEach
	public void setUp() {
		
		category=new Category();
		
		category.setCategoryName("Electronics");
		category.setCategoryDescription("This is Electronics");
		
		categoryDao.addCategory(category);
		
		SubCategory subCategory1=new SubCategory();
		subCategory1.setCategory(category);
		subCategory1.setSubCategoryName("Mobile");
		subCategory1.setSubCategoryDescription("This is Mobile Section");
		
		subCategoryDao.addSubCategory(subCategory1);
		
		
		SubCategory subCategory2=new SubCategory();
		subCategory2.setCategory(category);
		subCategory2.setSubCategoryName("Laptop");
		subCategory2.setSubCategoryDescription("This is Laptop Section");
		
		subCategoryDao.addSubCategory(subCategory2);
		
		subCategories=new ArrayList<SubCategory>();
		subCategories.add(subCategory1);
		subCategories.add(subCategory2);
		
		attribute=new Attribute();
		
		attribute.setAttributeName("RAM");
		attribute.setSubCategories(subCategories);
		
	}
	
	
	@Test
	public void testAddAttribute() {
		assertTrue(attributeDao.addAttribute(attribute));
	}
	
	
	@Test
	public void testAddAttributeFailure() {
		subCategories.add(new SubCategory());
		attribute.setSubCategories(subCategories);
		assertFalse(attributeDao.addAttribute(attribute));
	}
	
	@Test
	public void testAddAttributeWithNullSubCategories() {
		attribute.setSubCategories(null);
		assertFalse(attributeDao.addAttribute(attribute));
	}
	
	
	@Test
	public void testGetAttribute() {
		attributeDao.addAttribute(attribute);
		assertNotNull(attributeDao.get(attribute.getAttributeId()));
		assertEquals(attribute.getAttributeName(),attributeDao.get(attribute.getAttributeId()).getAttributeName());	
	}
	
	@Test
	public void testGetAttributeFailure() {
		assertNull(attributeDao.get(22));
	}
	
	
	@Test
	public void testUpdateAttribute() {
		
	}
	
	@AfterEach
	public void tearDown() {
		if(attributeDao.get(attribute.getAttributeId())!=null) {
			attributeDao.deleteAttribute(attribute);
		}
		
		for(SubCategory subCategory:subCategories) {
			if(subCategoryDao.get(subCategory.getSubCategoryId())!=null) {
				subCategoryDao.deleteSubCategory(subCategory);
			}
		}
		
		
		if(categoryDao.get(category.getCategoryId())!=null) {
			categoryDao.deleteCategory(category);
		}
	}
	
}
