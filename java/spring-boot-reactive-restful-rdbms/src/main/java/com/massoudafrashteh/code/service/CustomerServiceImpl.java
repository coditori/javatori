package com.massoudafrashteh.code.service;

import com.massoudafrashteh.code.model.Customer;
import com.massoudafrashteh.code.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Mono<Customer> save(Customer customer) {
        return Mono.just(customerRepository.save(customer));
    }

    @Override
    public Mono<Customer> findById(Long id) {
        return Mono.just(customerRepository.findById(id).get());
    }

    @Override
    public Flux<Customer> findAll() {
        return Flux.fromIterable(customerRepository.findAll());
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        customerRepository.deleteById(id);
        return Mono.empty();
    }
}
