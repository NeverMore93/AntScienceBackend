package com.as.backend.antscience.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by lirui on 2018/1/30.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserExistedException extends RuntimeException {
    public UserExistedException(String message) {
        super(message);
    }
}
