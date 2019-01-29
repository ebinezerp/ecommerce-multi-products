package b190172.backend;

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
import b190172.backend.dao.ProductDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.Attribute;
import b190172.backend.model.Category;
import b190172.backend.model.Product;
import b190172.backend.model.ProductAttributeValue;
import b190172.backend.model.SubCategory;

@SpringJUnitConfig(classes = { HibernateConfig.class })
public class ProductTestCase {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private SubCategoryDao subCategoryDao;

	@Autowired
	private AttributeDao attributeDao;

	@Autowired
	private ProductDao productDao;

	private Category category;
	private SubCategory subCategory;
	private List<SubCategory> subCategories;
	private List<Attribute> attributes;
	private Product product;

	@BeforeEach
	public void setUp() {
		category = new Category();

		category.setCategoryName("Electronics");
		category.setCategoryDescription("This is Electronics");

		categoryDao.addCategory(category);

		SubCategory subCategory1 = new SubCategory();
		subCategory1.setCategory(category);
		subCategory1.setSubCategoryName("Mobile");
		subCategory1.setSubCategoryDescription("This is Mobile Section");

		subCategoryDao.addSubCategory(subCategory1);

		SubCategory subCategory2 = new SubCategory();
		subCategory2.setCategory(category);
		subCategory2.setSubCategoryName("Laptop");
		subCategory2.setSubCategoryDescription("This is Laptop Section");

		subCategoryDao.addSubCategory(subCategory2);

		subCategories = new ArrayList<SubCategory>();
		subCategories.add(subCategory1);
		subCategories.add(subCategory2);

		Attribute attribute1 = new Attribute();

		attribute1.setAttributeName("RAM");
		attribute1.setSubCategories(subCategories);

		Attribute attribute2 = new Attribute();
		attribute2.setAttributeName("Internal Memory");
		attribute2.setSubCategories(subCategories);

		attributes=new ArrayList<Attribute>();
		
		attributes.add(attribute1);
		attributes.add(attribute2);

		attributeDao.addAttribute(attribute1);
		attributeDao.addAttribute(attribute2);

		ProductAttributeValue productAttributeValue1 = new ProductAttributeValue();
		productAttributeValue1.setAttribute(attribute1);
		productAttributeValue1.setAttributeValue("4GB");

		ProductAttributeValue productAttributeValue2 = new ProductAttributeValue();
		productAttributeValue2.setAttribute(attribute2);
		productAttributeValue2.setAttributeValue("64GB");

		List<ProductAttributeValue> productAttributeValues = new ArrayList<ProductAttributeValue>();
		productAttributeValues.add(productAttributeValue1);
		productAttributeValues.add(productAttributeValue2);

		product = new Product();

		product.setProductName("J");
		product.setProductModel("J7");
		product.setBrand("Samsung");
		product.setPrice(17000f);
		product.setProductAttributeValues(productAttributeValues);

	}
	
	
	@Test
	public void testAddProduct() {
		assertTrue(productDao.addProduct(product));
	}
	
	
	@AfterEach
	public void tearDown() {
		
		if(productDao.getProduct(product.getProductId())!=null) {
			productDao.deleteProduct(product);
		}
		
		
		for(Attribute attribute:attributes) {
			if(attributeDao.get(attribute.getAttributeId())!=null) {
				attributeDao.deleteAttribute(attribute);
			}
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
