package com.feng.springbootthumbup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootThumbupApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootThumbupApplication.class, args);
    }

}
