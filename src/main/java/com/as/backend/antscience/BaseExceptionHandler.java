package com.as.backend.antscience;

import com.alibaba.fastjson.JSONObject;
import com.as.backend.antscience.exceptions.TokenInvalidException;
import com.ucardstore.util.exception.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

// 异常处理类
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = TokenInvalidException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public TokenInvalidException handleInvalidParamsException(TokenInvalidException ) {
        return new InvalidParamsException;
    }
}
e