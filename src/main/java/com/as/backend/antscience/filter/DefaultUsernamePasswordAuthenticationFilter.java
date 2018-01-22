package com.as.backend.antscience.filter;

import com.as.backend.antscience.security.DefaultUsernamePasswordAuthenticationToken;
import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefaultUsernamePasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public DefaultUsernamePasswordAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException{
        String str = request.getQueryString();
        DefaultUsernamePasswordAuthenticationToken defaultUsernamePasswordAuthenticationToken = new DefaultUsernamePasswordAuthenticationToken("username","password");


        return null;
    }

    protected void setDetails(HttpServletRequest request, DefaultUsernamePasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }
}
