package com.as.backend.antscience.filter;


import com.as.backend.antscience.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class AuthorityFilter extends HttpServlet implements Filter {

    private static final long serialVersionUID = 1L;
    private static final String AUTH = "/auth/";

    @Resource(name ="tokenService" )
    private TokenService tokenService;

    @Override
    public void init(FilterConfig arg0){
    }

    @Override
    public void doFilter(ServletRequest sRequest, ServletResponse sResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sRequest;
        log.info(sRequest.toString());
        String token = request.getHeader("token");
        String userName = request.getHeader("userName");
        log.info("token: " + token);
        log.info("userName: " + userName);
        HttpServletResponse response = (HttpServletResponse) sResponse;
        String url = request.getServletPath();
        if (!url.contains(AUTH)) {
            log.info("开始拦截验证， 处理Token");
            token = tokenService.identify(token, userName);
            response.setHeader("token", token);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
