package com.as.backend.antscience.config;

import com.as.backend.antscience.utils.SMSHttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.AsyncRestTemplate;

@Configuration
@Slf4j(topic = "SubMailConfig")
public class SMSConfig {

    @Bean(name="smsHttpRequest")
    public SMSHttpRequest smsHttpRequest(){
        SMSHttpRequest smsHttpRequest = new SMSHttpRequest();
        smsHttpRequest.setAppid("18631");
        smsHttpRequest.setProject("hIdfR3");
        smsHttpRequest.setSignature("17d0979bebbe51d711119d08271d4880");
        return smsHttpRequest;
    }
}
