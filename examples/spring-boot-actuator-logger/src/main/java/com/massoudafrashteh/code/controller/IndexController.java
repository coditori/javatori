package com.massoudafrashteh.code.controller;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@Repository
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "Hello World!";
    }
}
