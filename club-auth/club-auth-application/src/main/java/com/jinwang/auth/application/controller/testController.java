package com.jinwang.auth.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jinwang
 * @Date 2024/10/15 10:08
 * @Version 1.0 （版本号）
 */

@RestController
public class testController {



    @GetMapping("test")
    public String test(){
        return "test";
    }
}
