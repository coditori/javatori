package com.massoudafrashteh.code.service;

import com.massoudafrashteh.code.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> save(User user);

    Optional<User> findById(long id);

    Optional<List<User>> findAll();

    Optional<User> update(long id, User user);

    void deleteById(long id);
}
