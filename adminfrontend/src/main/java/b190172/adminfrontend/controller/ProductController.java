package b190172.adminfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import b190172.backend.dao.CategoryDao;
import b190172.backend.dao.ProductDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductDao productDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	

}
