package com.jinwang.auth.application.controller;

import com.jinwang.auth.application.convert.AuthUserDTOConverter;
import com.jinwang.auth.domain.entity.AuthUserBO;
import com.jinwang.auth.domain.service.AuthUserDomainService;
import com.jinwang.auth.entity.AuthUserDTO;
import com.jinwang.auth.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/")
@Slf4j
public class UserController {

    @Resource
    private AuthUserDomainService authUserDomainService;

    /*
     * @Description: 用户注册
     */
    @RequestMapping("register")
    public Result<Boolean> register(@RequestBody AuthUserDTO authUserDTO) {
        log.info("用户注册开始，用户名： {}", authUserDTO.getUserName());
        try {
            AuthUserBO authUserBO = AuthUserDTOConverter.INSTANCE.convertDTOToBO(authUserDTO);
            return Result.ok(authUserDomainService.register(authUserBO));
        } catch (Exception e) {
            log.error("用户注册失败，用户名： {}， error：{}", authUserDTO.getUserName(), e.getMessage());
            return Result.fail("用户注册失败");
        }
    }
}
