package com.example.springbootmybatis;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SpringbootMybatisApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return  builder.sources(SpringbootMybatisApplication.class);
    }
}
