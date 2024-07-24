package com.pmoran.devsu.service.cuenta.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class WebConfig {

    @Value("${service.integration.timeout}")
    private int timeout;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMillis(timeout * 1000))
                .setReadTimeout(Duration.ofMillis(timeout * 1000))
                .build();
    }

}
