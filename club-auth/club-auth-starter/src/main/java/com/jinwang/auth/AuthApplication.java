package com.jinwang.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author jinwang
 * @Date 2024/10/14 19:21
 * @Version 1.0 （版本号）
 */
@SpringBootApplication
@ComponentScan("com.jinwang")
@MapperScan("com.jinwang.**.mapper")
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class);
    }
}
