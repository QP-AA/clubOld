package com.jinwang.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.google.gson.Gson;
import com.jinwang.auth.domain.constants.AuthConstant;
import com.jinwang.auth.domain.convert.AuthUserBOConverter;
import com.jinwang.auth.domain.entity.AuthUserBO;
import com.jinwang.auth.domain.service.AuthUserDomainService;
import com.jinwang.auth.infra.basic.entity.*;
import com.jinwang.auth.infra.basic.service.*;
import com.jinwang.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    AuthUserRoleService authUserRoleService;

    @Resource
    AuthRolePermissionService authRolePermissionService;

    @Resource
    AuthPermissionService authPermissionService;

    @Resource
    RedisUtil redisUtil;

    private static final String authRolePrefix = "auth.role";

    private static final String authPermissionPrefix = "auth.permission";

    private static final String LOGIN_PREFIX = "loginCode";

    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser exitAuthUser = new AuthUser();
        exitAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUsers = authUserService.queryByCondition(exitAuthUser);
        if (!CollectionUtils.isEmpty(existUsers)) {
            return true;
        }
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        if (StringUtils.isNotBlank(authUser.getPassword())) {
            authUser.setPassword(SaSecureUtil.md5(authUser.getPassword()));
        }
        log.info("开始注册到数据库");
        Integer cnt = authUserService.insert(authUser);

        // 建立角色关联
        AuthRole authRole = new AuthRole();
        authRole.setRoleKey(AuthConstant.NORMAL_USER);
        AuthRole resRole = authRoleService.queryByCondition(authRole);
        Long roleId = resRole.getId();
        Long userId = authUser.getId();
        AuthUserRole authUserRole = new AuthUserRole();
        authUserRole.setUserId(userId);
        authUserRole.setRoleId(roleId);
        log.info("开始建立用户角色关联");
        authUserRoleService.insert(authUserRole);

        // 用户-角色对应
        String roleKey = redisUtil.buildKey(authRolePrefix, authUser.getUserName());
        List<AuthRole> roleList = new ArrayList<>();
        roleList.add(authRole);
        redisUtil.set(roleKey, new Gson().toJson(roleList));

        // 角色-权限对应
        AuthRolePermission authRolePermission = new AuthRolePermission();
        authRolePermission.setRoleId(Math.toIntExact(roleId));
        List<AuthRolePermission> rolePermissionList = authRolePermissionService.queryByCondition(authRolePermission);
        List<Integer> permissionIdList = rolePermissionList.stream().map(AuthRolePermission::getPermissionId).collect(Collectors.toList());
        List<AuthPermission> authPermissionList = permissionIdList.stream().map(id -> authPermissionService.queryById(id)).collect(Collectors.toList());
        String permissionKey = redisUtil.buildKey(authPermissionPrefix, authUser.getUserName());
        redisUtil.set(permissionKey, new Gson().toJson(authPermissionList));


        return cnt > 0;
    }

    @Override
    public Boolean update(AuthUserBO authUserBO) {
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        Integer cnt = authUserService.update(authUser);
        log.info("开始修改用户信息，id： {}", authUser.getId());
        return cnt > 0;
    }

    @Override
    public Boolean delete(AuthUserBO authUserBO) {
        return authUserService.deleteById(authUserBO.getId());
    }

    @Override
    public SaTokenInfo doLogin(String validCode) {
        String loginKey = redisUtil.buildKey(LOGIN_PREFIX, validCode);
        String openId = redisUtil.get(loginKey);
        if (StringUtils.isBlank(openId)) {
            throw new RuntimeException("验证码错误");
        }
        AuthUserBO authUserBO = new AuthUserBO();
        authUserBO.setUserName(openId);
        this.register(authUserBO);
        StpUtil.login(openId);
        return StpUtil.getTokenInfo();
    }
}
