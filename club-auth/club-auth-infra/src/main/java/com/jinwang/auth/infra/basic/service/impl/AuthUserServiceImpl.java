package com.jinwang.auth.infra.basic.service.impl;

import com.jinwang.auth.infra.basic.entity.AuthUser;
import com.jinwang.auth.infra.basic.mapper.AuthUserDao;
import com.jinwang.auth.infra.basic.service.AuthUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUser)表服务实现类
 *
 * @author makejava
 * @since 2024-10-15 10:28:53
 */
@Service("authUserService")
public class AuthUserServiceImpl implements AuthUserService {
    @Resource
    private AuthUserDao authUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public AuthUser queryById(Integer id) {
        return this.authUserDao.queryById(id);
    }

    /**
     * 新增数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUser insert(AuthUser authUser) {
        this.authUserDao.insert(authUser);
        return authUser;
    }

    /**
     * 修改数据
     *
     * @param authUser 实例对象
     * @return 实例对象
     */
    @Override
    public AuthUser update(AuthUser authUser) {
        this.authUserDao.update(authUser);
        return this.queryById(authUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.authUserDao.deleteById(id) > 0;
    }
}
