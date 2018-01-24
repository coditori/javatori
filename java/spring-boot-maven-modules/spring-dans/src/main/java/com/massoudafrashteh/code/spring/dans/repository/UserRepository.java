package com.massoudafrashteh.code.spring.dans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.massoudafrashteh.code.spring.dans.domain.User;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

}
