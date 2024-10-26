package com.jinwang.auth.application.controller;

import com.jinwang.auth.application.convert.AuthRolePermissionDTOConverter;
import com.jinwang.auth.application.dto.AuthRolePermissionDTO;
import com.jinwang.auth.domain.entity.AuthRolePermissionBO;
import com.jinwang.auth.domain.service.AuthRolePermissionDomainService;
import com.jinwang.auth.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rolePermission/")
@Slf4j
public class RolePermissionController {

    @Resource
    AuthRolePermissionDomainService AuthRolePermissionDomainService;

    /**
     * 添加权限
     * @param AuthRolePermissionDTO
     * @return
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthRolePermissionDTO AuthRolePermissionDTO) {
        try {
            AuthRolePermissionBO AuthRolePermissionBO = AuthRolePermissionDTOConverter.INSTANCE.convertDTOToBO(AuthRolePermissionDTO);
            return Result.ok(AuthRolePermissionDomainService.add(AuthRolePermissionBO));
        } catch (Exception e) {
            log.error("添加角色权限失败", e);
            return Result.fail("添加角色权限失败");
        }
    }
}
