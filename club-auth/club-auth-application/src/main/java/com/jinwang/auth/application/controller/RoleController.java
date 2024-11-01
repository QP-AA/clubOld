package com.jinwang.auth.application.controller;

import com.jinwang.auth.application.convert.AuthRoleDTOConverter;
import com.jinwang.auth.application.dto.AuthRoleDTO;
import com.jinwang.auth.domain.convert.AuthRoleBOConverter;
import com.jinwang.auth.domain.entity.AuthRoleBO;
import com.jinwang.auth.domain.service.AuthRoleDomainService;
import com.jinwang.auth.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author jinwang
 * @Date 2024/10/23 10:31
 * @Version 1.0 （版本号）
 */
@RestController
@RequestMapping("/role/")
@Slf4j
public class RoleController {

    @Resource
    AuthRoleDomainService authRoleDomainService;

    /**
     * 添加角色
     * @param authRoleDTO
     * @return
     */
    @RequestMapping("add")
    public Result<Boolean> add(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.add(authRoleBO));
        } catch (Exception e) {
            log.error("添加角色失败", e);
            return Result.fail("添加角色失败");
        }
    }

    /**
     * 更新角色
     * @param authRoleDTO
     * @return
     */
    @RequestMapping("update")
    public Result<Boolean> update(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.update(authRoleBO));
        } catch (Exception e) {
            log.error("更新角色失败", e);
            return Result.fail("更新角色失败");
        }
    }

    @RequestMapping("delete")
    public Result<Boolean> delete(@RequestBody AuthRoleDTO authRoleDTO) {
        try {
            AuthRoleBO authRoleBO = AuthRoleDTOConverter.INSTANCE.convertDTOToBO(authRoleDTO);
            return Result.ok(authRoleDomainService.delete(authRoleBO));
        } catch (Exception e) {
            log.error("删除角色失败", e);
            return Result.fail("删除角色失败");
        }
    }
}
