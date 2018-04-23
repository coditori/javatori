package com.massoudafrashteh.code.service;

import com.massoudafrashteh.code.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Mono<Customer> save(Customer customer);
    Mono<Customer> findById(String id);
    Flux<Customer> findAll();
    Mono<Void> deleteById(String id);
}
