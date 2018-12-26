package b190172.frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import b190172.backend.dao.CategoryDao;

@Controller
public class IndexController {

	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("/")
	public String index(Model model, HttpSession session) {
		session.setAttribute("categories", categoryDao.getCategories());
		return "index";
	}
}
