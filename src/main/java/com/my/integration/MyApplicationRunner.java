package com.my.integration;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: Lai Haimeng
 * @date: 2023/12/20
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MyApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class);
        System.out.println("=====My Integration started=====");
    }
}
