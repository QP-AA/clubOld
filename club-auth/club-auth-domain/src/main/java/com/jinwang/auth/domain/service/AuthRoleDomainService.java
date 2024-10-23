package com.jinwang.auth.domain.service;

import com.jinwang.auth.domain.entity.AuthRoleBO;

/**
 * @Author jinwang
 * @Date 2024/10/23 14:56
 * @Version 1.0 （版本号）
 */
public interface AuthRoleDomainService {
    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);
}
