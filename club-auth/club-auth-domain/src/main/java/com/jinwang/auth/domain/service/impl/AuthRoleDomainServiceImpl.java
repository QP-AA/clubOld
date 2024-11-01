package com.jinwang.auth.domain.service.impl;

import com.jinwang.auth.domain.convert.AuthRoleBOConverter;
import com.jinwang.auth.domain.entity.AuthRoleBO;
import com.jinwang.auth.domain.service.AuthRoleDomainService;
import com.jinwang.auth.infra.basic.entity.AuthRole;
import com.jinwang.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author jinwang
 * @Date 2024/10/23 14:58
 * @Version 1.0 （版本号）
 */
@Service
public class AuthRoleDomainServiceImpl implements AuthRoleDomainService {

    @Resource
    private AuthRoleService authRoleService;
    @Override
    public Boolean add(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        int cnt = authRoleService.insert(authRole);
        return cnt > 0;
    }

    @Override
    public Boolean update(AuthRoleBO authRoleBO) {
        AuthRole authRole = AuthRoleBOConverter.INSTANCE.convertBOToEntity(authRoleBO);
        int cnt = authRoleService.update(authRole);
        return cnt > 0;
    }

    @Override
    public Boolean delete(AuthRoleBO authRoleBO) {
        return authRoleService.deleteById(authRoleBO.getId());
    }
}
