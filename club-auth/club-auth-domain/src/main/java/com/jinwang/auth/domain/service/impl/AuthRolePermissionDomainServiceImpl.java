package com.jinwang.auth.domain.service.impl;

import com.jinwang.auth.domain.convert.AuthRolePermissionBOConverter;
import com.jinwang.auth.domain.entity.AuthRolePermissionBO;
import com.jinwang.auth.domain.service.AuthRolePermissionDomainService;
import com.jinwang.auth.infra.basic.entity.AuthRolePermission;
import com.jinwang.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jinwang
 * @Date 2024/10/23 14:58
 * @Version 1.0 （版本号）
 */
@Service
public class AuthRolePermissionDomainServiceImpl implements AuthRolePermissionDomainService {

    @Resource
    private AuthRolePermissionService AuthRolePermissionService;
    @Override
    public Boolean add(AuthRolePermissionBO authRolePermissionBO) {
        List<AuthRolePermission> rolePermissionList;
        Long roleId = authRolePermissionBO.getRoleId();
        rolePermissionList = authRolePermissionBO.getPermissionIdList().stream().map(permissionId -> {
            AuthRolePermission authRolePermission = new AuthRolePermission();
            authRolePermission.setRoleId(Math.toIntExact(roleId));
            authRolePermission.setPermissionId(Math.toIntExact(permissionId));
            return authRolePermission;
        }).collect(Collectors.toList());
        int cnt = AuthRolePermissionService.insertBatch(rolePermissionList);
        return cnt > 0;
    }
}
