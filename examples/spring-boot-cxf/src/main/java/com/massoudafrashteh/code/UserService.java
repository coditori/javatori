package com.massoudafrashteh.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
@Transactional
@Configurable
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> save(final User user) {
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> findById(final long id) {
        return userRepository.findById(id);
    }

    public Optional<List<User>> findAll() {
        System.out.println("INSIDE find ALL");
        return Optional.of(userRepository.findAll());
    }

    public Optional<User> update(final long id, final User user) {

        if (this.findById(id).isPresent()) {
            user.setId(id);
            return this.save(user);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void deleteById(final long id) {
        userRepository.deleteById(id);
    }
}