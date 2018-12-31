package b190172.adminfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import b190172.backend.dao.AttributeDao;
import b190172.backend.dao.SubCategoryDao;
import b190172.backend.model.Attribute;

@Controller
public class AttributeController {
	
	@Autowired
	private SubCategoryDao subCategoryDao;
	
	@Autowired
	private AttributeDao attributeDao;
	
	@GetMapping("/addattribute")
	public String addAttributePage(Model model) {
		model.addAttribute("attribute", new Attribute());
		model.addAttribute("subCategories", subCategoryDao.getSubCategories());
		return "addattribute";
	}
	
	
	@PostMapping("/addattribute")
	public String addNewAttribute(@ModelAttribute("attribute")Attribute attribute) {
		if(attributeDao.addAttribute(attribute)) {
		return "redirect:/addattribute";
		}else {
			return "addattribute";
		}
	}

}
