package com.feng.springbootredissession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@EnableRedisHttpSession
public class SpringbootRedisSessionApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisSessionApplication.class, args);
    }
}
