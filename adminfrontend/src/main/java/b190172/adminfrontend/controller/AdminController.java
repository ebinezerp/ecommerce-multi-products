package b190172.adminfrontend.controller;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import b190172.backend.dao.AdminDao;
import b190172.backend.dao.CategoryDao;
import b190172.backend.model.AdminDetails;
import b190172.backend.model.Category;

@Controller
public class AdminController {
	
	
	
	@Autowired
	private AdminDao adminDao;
	
	
	@PostMapping("/login")
	public String login(@RequestParam("employeeId") String employeeId, @RequestParam("password") String password,
			HttpSession session) {

		AdminDetails adminDetails = adminDao.login(employeeId, password);

		if (adminDetails != null) {
			session.setAttribute("adminDetails", adminDetails);
			return "redirect:/home";
		} else {
			return "redirect:/";
		}

	}

	@GetMapping("/home")
	public String home(HttpSession session) {
		if (session.getAttribute("adminDetails") != null) {
			return "home";
		} else {
			return "redirect:/";
		}
	}

}
