package com.jinwang.auth.domain.service.impl;

import com.jinwang.auth.domain.convert.AuthPermissionBOConverter;
import com.jinwang.auth.domain.entity.AuthPermissionBO;
import com.jinwang.auth.domain.service.AuthPermissionDomainService;
import com.jinwang.auth.infra.basic.entity.AuthPermission;
import com.jinwang.auth.infra.basic.service.AuthPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author jinwang
 * @Date 2024/10/23 14:58
 * @Version 1.0 （版本号）
 */
@Service
public class AuthPermissionDomainServiceImpl implements AuthPermissionDomainService {

    @Resource
    private AuthPermissionService authPermissionService;
    @Override
    public Boolean add(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        int cnt = authPermissionService.insert(authPermission);
        return cnt > 0;
    }

    @Override
    public Boolean update(AuthPermissionBO authPermissionBO) {
        AuthPermission authPermission = AuthPermissionBOConverter.INSTANCE.convertBOToEntity(authPermissionBO);
        int cnt = authPermissionService.update(authPermission);
        return cnt > 0;
    }

    @Override
    public Boolean delete(AuthPermissionBO authPermissionBO) {
        return authPermissionService.deleteById(authPermissionBO.getId());
    }
}
