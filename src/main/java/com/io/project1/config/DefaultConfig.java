package com.io.project1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DefaultConfig {

    @Bean
    public DefaultBean defaultBean() {
        return new DefaultBean();
    }
}
