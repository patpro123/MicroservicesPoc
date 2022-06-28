package com.partho.poc.webcrawlerservice.config;

import com.partho.poc.webcrawlerservice.clients.NewsFeedClient;
import com.partho.poc.webcrawlerservice.clients.gNewsClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){

         return builder
                 .setConnectTimeout(Duration.ofSeconds(5))
                 .build();
    }


    @Bean
    public NewsFeedClient newsFeedClient(){
        return new gNewsClient();
    }
}
