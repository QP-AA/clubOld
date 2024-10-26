package com.jinwang.auth.infra.basic.service.impl;

import com.jinwang.auth.infra.basic.entity.AuthRolePermission;
import com.jinwang.auth.infra.basic.mapper.AuthRolePermissionDao;
import com.jinwang.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2024-10-24 11:13:39
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl implements AuthRolePermissionService {
    @Resource
    private AuthRolePermissionDao authRolePermissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AuthRolePermission queryById(Integer id) {
        return this.authRolePermissionDao.queryById(id);
    }

    @Override
    public List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission) {
        return this.authRolePermissionDao.queryAllByLimit(authRolePermission);
    }


    /**
     * 分页查询
     *
     * @param authRolePermission 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<AuthRolePermission> queryByPage(AuthRolePermission authRolePermission, PageRequest pageRequest) {
        long total = this.authRolePermissionDao.count(authRolePermission);
        return new PageImpl<>(this.authRolePermissionDao.queryAllByLimit(authRolePermission), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public Integer insert(AuthRolePermission authRolePermission) {
        return this.authRolePermissionDao.insert(authRolePermission);
    }

    @Override
    public Integer insertBatch(List<AuthRolePermission> authRolePermissions) {
        return this.authRolePermissionDao.insertBatch(authRolePermissions);
    }

    /**
     * 修改数据
     *
     * @param authRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public AuthRolePermission update(AuthRolePermission authRolePermission) {
        this.authRolePermissionDao.update(authRolePermission);
        return this.queryById(authRolePermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.authRolePermissionDao.deleteById(id) > 0;
    }
}
