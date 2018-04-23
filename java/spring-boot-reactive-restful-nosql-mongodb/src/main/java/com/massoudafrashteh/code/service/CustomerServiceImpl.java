package com.massoudafrashteh.code.service;

import com.massoudafrashteh.code.model.Customer;
import com.massoudafrashteh.code.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<Customer> save(Customer customer) {
        customer.setId(null);
        return customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> findById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        System.out.println("Inside customer service");
        return customerRepository.deleteById(id);
    }
}