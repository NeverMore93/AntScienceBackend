package com.as.backend.antscience;

import com.as.backend.antscience.exceptions.TokenInvalidException;
import com.as.backend.antscience.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = TokenInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public TokenInvalidException handleInvalidParamsException(TokenInvalidException e) {
        return e;
    }

    @ExceptionHandler(value = UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UserNotFoundException userNotFoundException(UserNotFoundException e) {
        return e;
    }
}