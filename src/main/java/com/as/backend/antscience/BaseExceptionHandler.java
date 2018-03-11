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

    }