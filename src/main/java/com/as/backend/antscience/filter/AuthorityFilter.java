package com.as.backend.antscience.filter;


import com.as.backend.antscience.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthorityFilter extends OncePerRequestFilter {

    private static final long serialVersionUID = 1L;
    private static final String AUTH = "/auth/";

    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest sRequest, HttpServletResponse sResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) sRequest;
        ServletContext context = request.getServletContext();
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
        tokenService = ctx.getBean(TokenService.class);
        log.info(sRequest.toString());
        String token = request.getHeader("token");
        String userName = request.getHeader("userName");
        log.info("token: " + token);
        log.info("userName: " + userName);
        HttpServletResponse response = (HttpServletResponse) sResponse;
        String url = request.getServletPath();
        if (!url.contains(AUTH) && !url.equals("/")) {
            log.info("开始拦截验证， 处理Token");
            token = tokenService.identify(token, userName);
            response.setHeader("token", token);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
