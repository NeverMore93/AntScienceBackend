package com.as.backend.antscience;

import com.as.backend.antscience.exceptions.TokenInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = TokenInvalidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public TokenInvalidException handleInvalidParamsException() {
        return new TokenInvalidException("token无效");
    }
}