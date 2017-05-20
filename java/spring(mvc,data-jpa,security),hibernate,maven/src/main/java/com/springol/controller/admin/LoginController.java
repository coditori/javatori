package com.springol.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login", method = RequestMethod.GET)
public class LoginController {
	
	@GetMapping("/403")
	public String page403(){
		return "/admin/login/403";
	}
	
	@GetMapping("/admin")
	public String login() {
		return "admin/login/login";
	}
}
