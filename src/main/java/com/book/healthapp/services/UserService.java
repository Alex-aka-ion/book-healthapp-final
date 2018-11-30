package com.book.healthapp.services;

import com.book.healthapp.domain.User;

public interface UserService {
    User save(User u);

    void update(User u);

    User doesUserExist(String email);

    User getByEmail(String email);

    User isValidUser(String email, String password);
}
