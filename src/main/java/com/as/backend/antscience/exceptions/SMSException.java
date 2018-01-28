package com.as.backend.antscience.exceptions;

public class SMSException extends RuntimeException {
    public SMSException(String msg,Throwable t){
        super(msg,t);
    }
}
