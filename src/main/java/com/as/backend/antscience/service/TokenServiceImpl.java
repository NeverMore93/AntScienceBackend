package com.as.backend.antscience.service;

import com.as.backend.antscience.exceptions.TokenInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service(value = "tokenService")
public class TokenServiceImpl implements TokenService {
    private static final String SIGNING_KEY = "secret";
    private static final Integer FIFTEEN_MINUTES = 15 * 60 * 1000;

    public String buildToken(String userName) {
        Date currentTime = new Date();
        long t = currentTime.getTime();
        Date expirationTime = new Date(t + FIFTEEN_MINUTES);
        Claims claims = Jwts.claims().setSubject(userName).setExpiration(expirationTime);
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, SIGNING_KEY).compact();
    }

    @ApiOperation("判断Token是否过期")
    public Boolean isExpired(String token) {
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
        Date expirationTime = claims.getExpiration();
        return expirationTime.before(new Date());
    }

    @ApiOperation("判断用户名是否被篡改")
    public Boolean isTampered(String token, String userName) {
        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
        return !claims.getSubject().equals(userName);
    }

    public Boolean isTokenEmpty(String token) {
        return token == null || "".equals(token) || "null".equals(token);
    }

    public String identify(String token, String userName) {
        if (isTokenEmpty(token)) {
            throw new TokenInvalidException("当前用户未认证,请先登录认证。");
        }
        if (isExpired(token)) {
            throw new TokenInvalidException("认证已经过期,请重新认证获取token。");
        }
        if (isTampered(token, userName)) {
            throw new TokenInvalidException("请求头部的用户名与token中的不一致,请求可能被篡改。");
        }
        return buildToken(userName);
    }
}
