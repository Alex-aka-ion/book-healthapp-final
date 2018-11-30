package com.book.healthapp.services;

import com.book.healthapp.domain.User;
import com.book.healthapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User u) {
        userRepository.save(u);
        return u;
    };

    @Override
    public void update(User u) {
        userRepository.save(u);
    };

    @Override
    public User doesUserExist(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User isValidUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
