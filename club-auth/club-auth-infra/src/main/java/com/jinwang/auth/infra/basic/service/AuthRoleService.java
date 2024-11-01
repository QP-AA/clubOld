package com.jinwang.auth.infra.basic.service;

import com.jinwang.auth.infra.basic.entity.AuthRole;

/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2024-10-23 10:19:51
 */
public interface AuthRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRole queryById(Integer id);
    Integer insert(AuthRole authRole);

    /**
     * 修改数据
     *
     * @param authRole 实例对象
     * @return 实例对象
     */
    Integer update(AuthRole authRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    public AuthRole queryByCondition(AuthRole authRole);

}
