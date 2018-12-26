package b190172.adminfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import b190172.backend.dao.CategoryDao;
import b190172.backend.model.Category;

@Controller
public class CategoryController {

	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("/addcategory")
	public String addCategoryPage(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@PostMapping("/addcategory")
	public String addNewCategory(@ModelAttribute("category") Category category) {
		if (categoryDao.addCategory(category)) {
			return "redirect:/allcategories";
		}else {
			return "addcategory";
		}
	}
	
	
	@GetMapping("/allcategories")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryDao.getCategories());
		return "allcategories";
	}

}
