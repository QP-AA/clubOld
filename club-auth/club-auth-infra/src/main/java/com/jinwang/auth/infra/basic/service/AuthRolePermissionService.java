package com.jinwang.auth.infra.basic.service;

import com.jinwang.auth.infra.basic.entity.AuthRolePermission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (AuthRolePermission)表服务接口
 *
 * @author makejava
 * @since 2024-10-24 11:13:39
 */
public interface AuthRolePermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AuthRolePermission queryById(Integer id);

    /**
     * 根据条件查询
     *
     * @param authRolePermission
     * @return
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);

    /**
     * 分页查询
     *
     * @param authRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<AuthRolePermission> queryByPage(AuthRolePermission authRolePermission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    Integer insert(AuthRolePermission authRolePermission);

    /**
     * 批量插入
     * @param authRolePermissions
     * @return
     */

    Integer insertBatch(List<AuthRolePermission> authRolePermissions);

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    AuthRolePermission update(AuthRolePermission authRolePermission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
