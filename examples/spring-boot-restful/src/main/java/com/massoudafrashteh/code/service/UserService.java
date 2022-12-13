package com.massoudafrashteh.code.service;

import com.massoudafrashteh.code.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User save(final User user);
    User findById(final long id);
    List<User> findAll();
    User update(final long id, final User user);
    void deleteById(final long id);
}
