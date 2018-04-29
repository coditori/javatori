package com.massoudafrashteh.code.service.impl;

import com.massoudafrashteh.code.domain.User;
import com.massoudafrashteh.code.repository.UserRepository;
import com.massoudafrashteh.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> save(final User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> findById(final long id) {
        return Optional.of(userRepository.findOne(id));
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public Optional<User> update(final long id,
                                 final User user) {

        if (this.findById(id).isPresent()) {
            user.setId(id);
            return this.save(user);
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteById(final long id) {
        userRepository.delete(id);
    }
}