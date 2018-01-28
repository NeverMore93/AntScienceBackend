package com.as.backend.antscience.exceptions;


public class TokenInvalidException extends RuntimeException{
    private String msg;
    public TokenInvalidException(String msg){
        super(msg);
    }
}