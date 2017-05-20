package com.springol.controller.admin;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springol.model.Role;
import com.springol.model.User;
import com.springol.service.RoleService;
import com.springol.service.UserService;

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.GET)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	// convert role field in user list from String to int and check it in database
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    binder.registerCustomEditor(Role.class, "role", new PropertyEditorSupport(Role.class){
	    	@Override
	        public void setAsText(String text) {
	    		if(text != null) setValue(roleService.findById(Long.parseLong(text)));
	        }
	    });
	}
	
	@GetMapping("")
	public String index(Model model){
		model.addAttribute("pageTitle", "Admin main page");
		return "admin/admin-index";
	}
	
	@GetMapping("/user/list")
	public String hello(Model model) {
		model.addAttribute("pageTitle", "Users list");
		model.addAttribute("users", userService.getAll());
		return "admin/users";
	}
	
	@GetMapping("/user/add")
	public String addUserGet(Model model) {
		model.addAttribute("pageTitle", "Add user");
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.getAll());
		return "admin/add";
	}
	
	@PostMapping("/user/add")
	public String addUserPost(@ModelAttribute("user") User user, BindingResult r) {
		userService.save(user);
		return "redirect:/admin/user/list";
	}
}
