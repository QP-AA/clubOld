package com.jinwang.auth.infra.basic.service;

import com.jinwang.auth.infra.basic.entity.AuthPermission;

/**
 * (AuthPermission)表服务接口
 *
 * @author makejava
 * @since 2024-10-24 09:21:02
 */
public interface AuthPermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthPermission queryById(Integer id);

    /**
     * 根据条件查询数据
     * @param authPermission
     * @return
     */
    AuthPermission queryByCondition(AuthPermission authPermission);

    /**
     * 新增数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer insert(AuthPermission authPermission);

    /**
     * 修改数据
     *
     * @param authPermission 实例对象
     * @return 实例对象
     */
    Integer update(AuthPermission authPermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
}
