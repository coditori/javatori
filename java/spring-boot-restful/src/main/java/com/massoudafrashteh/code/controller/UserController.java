package com.massoudafrashteh.code.controller;

import com.massoudafrashteh.code.domain.User;
import com.massoudafrashteh.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user).get();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") final Long id) {
        return userService.findById(id).get();
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll().get();
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id,
                       @RequestBody User user) {
        return userService.update(id, user).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final Long id) {
        userService.deleteById(id);
    }
}