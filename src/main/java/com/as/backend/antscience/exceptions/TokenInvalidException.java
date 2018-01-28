package com.as.backend.antscience.exceptions;


public class TokenInvalidException extends RuntimeException{
    public TokenInvalidException(String msg){
        super(msg);
    }
}