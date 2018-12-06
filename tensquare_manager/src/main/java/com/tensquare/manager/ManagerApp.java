package com.tensquare.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import util.JwtUtil;

/**
 * @author chenyilei
 * @date 2018/12/04-20:28
 * hello everyone
 */
@EnableZuulProxy
@SpringBootApplication
@EnableEurekaClient
public class ManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApp.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "jwt.config")
    public JwtUtil jwtUtil(){
        return new JwtUtil();
    }
}
