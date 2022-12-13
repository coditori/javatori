package com.massoudafrashteh.code.controller;


import com.massoudafrashteh.code.model.Customer;
import com.massoudafrashteh.code.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{id}")
    public Mono<Customer> findById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @GetMapping
    public Flux<Customer> findAll() {
        return customerService.findAll();
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteById(@PathVariable("id") Long id) {
        return customerService.deleteById(id);
    }
}