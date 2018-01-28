package com.as.backend.antscience.config;

import com.as.backend.antscience.filter.AuthorityFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lirui on 2017/4/27.
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        AuthorityFilter authorityFilter = new AuthorityFilter();
        registrationBean.setFilter(authorityFilter);
        List<String> urlPatterns = new ArrayList<>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}