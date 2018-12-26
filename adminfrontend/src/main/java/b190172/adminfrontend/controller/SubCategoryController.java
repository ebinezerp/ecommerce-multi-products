package b190172.adminfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import b190172.backend.dao.CategoryDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.SubCategory;

@Controller
public class SubCategoryController {
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@GetMapping("/addsubcategory")
	public String addSubCategoryPage(Model model) {	
		model.addAttribute("categories", categoryDao.getCategories());
		model.addAttribute("subcategory", new SubCategory());
		return "addsubcategory";
	}
	
	@PostMapping("/addsubcategory")
	public String addNewSubCategory(@ModelAttribute("subCategory")SubCategory subCategory) {
		if(subCategoryDao.addSubCategory(subCategory)) {
			return "redirect:/allsubcategories";
		}else {
			return "addsubcategory";
		}
	}
	
	@GetMapping("/allsubcategories")
	public String allSubCategories(Model model) {
		model.addAttribute("subCategories", subCategoryDao.getSubCategories());
		return "allsubcategories";
		
	}

}
