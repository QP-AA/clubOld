package com.jinwang.club.gateway.auth;

/**
 * @Author jinwang
 * @Date 2024/10/17 10:52
 * @Version 1.0 （版本号）
 * 自定义权限验证接口扩展
 */

import cn.dev33.satoken.stp.StpInterface;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jinwang.club.gateway.entity.AuthPermission;
import com.jinwang.club.gateway.entity.AuthRole;
import com.jinwang.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisUtil redisUtil;

    private final String authPermissionPrefix = "auth.permission";

    private final String authRolePrefix = "auth.role";

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        return getAuth(loginId.toString(), authPermissionPrefix);
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        return getAuth(loginId.toString(), authRolePrefix);
    }

    private List<String> getAuth(String loginId, String prefix) {
        String authKey = redisUtil.buildKey(prefix, loginId);
        String authVal = redisUtil.get(authKey);
        if (StringUtils.isBlank(authVal)) {
            return Collections.emptyList();
        }

        List<String> authList = new ArrayList<>();
        if (StringUtils.equals(authRolePrefix, prefix)) {
            List<AuthRole> roles = new Gson().fromJson(authVal, new TypeToken<List<AuthRole>>() {
            }.getType());
            authList = roles.stream().map(AuthRole::getRoleKey).collect(Collectors.toList());
        } else if (StringUtils.equals(authPermissionPrefix, prefix))  {
            List<AuthPermission> roles = new Gson().fromJson(authVal, new TypeToken<List<AuthPermission>>() {
            }.getType());
            authList = roles.stream().map(AuthPermission::getPermissionKey).collect(Collectors.toList());
        }
        return authList;
    }

}
