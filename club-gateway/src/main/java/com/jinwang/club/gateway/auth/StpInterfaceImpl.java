package com.jinwang.club.gateway.auth;

/**
 * @Author jinwang
 * @Date 2024/10/17 10:52
 * @Version 1.0 （版本号）
 * 自定义权限验证接口扩展
 */

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的权限列表
        return ...;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        // 返回此 loginId 拥有的角色列表
        return ...;
    }

}
