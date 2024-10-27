package com.jinwang.weixin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jinwang
 * @Date 2024/10/27 10:58
 * @Version 1.0 （版本号）
 */

@RestController
@Slf4j
public class CallBackController {

    @RequestMapping("test")
    public String test(){
        return "test";
    }
}
