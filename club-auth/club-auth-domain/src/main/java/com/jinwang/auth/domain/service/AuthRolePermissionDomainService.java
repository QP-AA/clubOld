package com.jinwang.auth.domain.service;


import com.jinwang.auth.domain.entity.AuthRolePermissionBO;

/**
 * 用户领域service
 *
 * @author: jinwang
 * @date: 2023/11/1
 */
public interface AuthRolePermissionDomainService {

    /**
     * 新增
     */
    Boolean add(AuthRolePermissionBO AuthRolePermissionBO);
}

