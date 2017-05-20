package com.springol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class IndexController {
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("title", "Springol Index page");
		return "site/index";
	}
	
}
