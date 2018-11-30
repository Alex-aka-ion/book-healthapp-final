package com.book.healthapp.controllers;

import com.book.healthapp.domain.User;
import com.book.healthapp.helpers.ExecutionStatus;
import com.book.healthapp.services.DoctorService;
import com.book.healthapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class UserAccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private DoctorService doctorService;

    @PostMapping(value="/signup", produces="application/json")
    public ExecutionStatus processLogin(@RequestBody User reqUser) {
        User user = null;
        try {
            user = userService.isValidUser(reqUser.getEmail(),
                    reqUser.getPassword());
        } catch (Exception ex) {
            //logger.debug(ex.getMessage(), ex);
        }
        if(user == null) {
            return new ExecutionStatus("USER_LOGIN_UNSUCCESSFUL", "Username or password is incorrect. Please try again!");
        }
        return new ExecutionStatus("USER_LOGIN_SUCCESSFUL", "Login Successful!");
    }

}
