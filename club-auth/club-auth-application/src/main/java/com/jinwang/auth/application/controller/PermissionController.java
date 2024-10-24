package com.jinwang.auth.application.controller;

import com.jinwang.auth.application.convert.AuthPermissionDTOConverter;
import com.jinwang.auth.application.convert.AuthUserDTOConverter;
import com.jinwang.auth.application.dto.AuthPermissionDTO;
import com.jinwang.auth.domain.entity.AuthPermissionBO;
import com.jinwang.auth.domain.entity.AuthUserBO;
import com.jinwang.auth.domain.service.AuthPermissionDomainService;
import com.jinwang.auth.domain.service.AuthUserDomainService;
import com.jinwang.auth.entity.AuthUserDTO;
import com.jinwang.auth.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/permission/")
@Slf4j
public class PermissionController {

    @Resource
    AuthPermissionDomainService authPermissionDomainService;

    /**
     * 添加权限
     * @param authPermissionDTO
     * @return
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.add(authPermissionBO));
        } catch (Exception e) {
            log.error("添加权限失败", e);
            return Result.fail("添加权限失败");
        }
    }

    /**
     * 更新权限
     * @param authPermissionDTO
     * @return
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.update(authPermissionBO));
        } catch (Exception e) {
            log.error("更新权限失败", e);
            return Result.fail("更新权限失败");
        }
    }

    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthPermissionDTO authPermissionDTO) {
        try {
            AuthPermissionBO authPermissionBO = AuthPermissionDTOConverter.INSTANCE.convertDTOToBO(authPermissionDTO);
            return Result.ok(authPermissionDomainService.delete(authPermissionBO));
        } catch (Exception e) {
            log.error("删除权限失败", e);
            return Result.fail("删除权限失败");
        }
    }
}
