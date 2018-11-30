package com.book.healthapp.helpers;

import com.book.healthapp.domain.User;
import lombok.Data;

@Data
public class ExecutionStatus {
    private String code;
    private String message;
    private User user;

    public ExecutionStatus() {

    }

    public ExecutionStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ExecutionStatus(String code, String message, User user) {
        this.code = code;
        this.message = message;
        this.user = user;
    }
}
