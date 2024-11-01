package com.jinwang.auth.domain.service;


import com.jinwang.auth.domain.entity.AuthPermissionBO;

/**
 * 用户领域service
 *
 * @author: jinwang
 * @date: 2023/11/1
 */
public interface AuthPermissionDomainService {

    /**
     * 注册
     */
    Boolean add(AuthPermissionBO AuthPermissionBO);

    /**
     * 修改
     */
    Boolean update(AuthPermissionBO AuthPermissionBO);

    /**
     * 删除
     */
    Boolean delete(AuthPermissionBO AuthPermissionBO);
}

