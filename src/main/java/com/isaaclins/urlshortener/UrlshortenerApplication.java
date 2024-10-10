package com.isaaclins.urlshortener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.isaaclins.urlshortener.repository")
public class UrlshortenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlshortenerApplication.class, args);
    }
}