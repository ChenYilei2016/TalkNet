package com.tensquare.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
 * @author chenyilei
 * @date 2018/11/28-18:02
 * hello everyone
 */
@SpringBootApplication
public class SearchApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class, args);
    }
    @Bean
    public IdWorker idWorkker(){
        return new IdWorker(3, 3);
    }

}
