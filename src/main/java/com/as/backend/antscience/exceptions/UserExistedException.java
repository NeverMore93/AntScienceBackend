package com.as.backend.antscience.exceptions;

/**
 * Created by lirui on 2018/1/30.
 */
public class UserExistedException extends RuntimeException {
    public UserExistedException(String message) {
        super(message);
    }
}
