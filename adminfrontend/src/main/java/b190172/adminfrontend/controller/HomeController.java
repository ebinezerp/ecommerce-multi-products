package b190172.adminfrontend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import b190172.backend.dao.AdminDao;
import b190172.backend.model.AdminDetails;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

}
