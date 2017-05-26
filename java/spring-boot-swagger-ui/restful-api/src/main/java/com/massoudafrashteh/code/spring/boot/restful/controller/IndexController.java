package com.massoudafrashteh.code.spring.boot.restful.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}
