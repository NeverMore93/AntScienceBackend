package com.as.backend.antscience;

import com.as.backend.antscience.exceptions.TokenInvalidException;
import com.as.backend.antscience.exceptions.UserExistedException;
import com.as.backend.antscience.exceptions.UserNotFoundException;
import com.as.backend.antscience.exceptions.VerificationCodeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
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

    @ExceptionHandler(value = UserExistedException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UserExistedException userExistedException(UserExistedException e) {
        return e;
    }

    @ExceptionHandler(value = VerificationCodeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public VerificationCodeException verificationCodeException(VerificationCodeException e) {
        return e;
    }
}