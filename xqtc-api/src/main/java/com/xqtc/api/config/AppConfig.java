package com.xqtc.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("http://xqpark.vaiwan.com/sms/sendMessage")
    public String SMSurl;
}
