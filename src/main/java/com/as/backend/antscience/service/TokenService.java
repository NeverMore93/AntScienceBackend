package com.as.backend.antscience.service;

public interface TokenService {
    String buildToken(String userName);
    Boolean isExpired(String token);
    Boolean isTampered(String token, String userName);
    Boolean isTokenEmpty(String token);
    String identify(String token, String userName);
}
