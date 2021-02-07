package org.example.oauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = {"org.example.oauth2.dao","org.example.oauth2.dao.*"})
@SpringBootApplication
public class TestSecurityOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(TestSecurityOauth2Application.class, args);
    }

}
