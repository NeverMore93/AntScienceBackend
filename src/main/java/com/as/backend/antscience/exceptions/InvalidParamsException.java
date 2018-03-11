package com.as.backend.antscience.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xubt on 8/24/16.
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidParamsException extends RuntimeException {
    public InvalidParamsException(String message) {
        super(message);
    }
}
