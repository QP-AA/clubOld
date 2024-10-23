package com.jinwang.auth.domain.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.jinwang.auth.domain.constants.AuthConstant;
import com.jinwang.auth.domain.convert.AuthUserBOConverter;
import com.jinwang.auth.domain.entity.AuthUserBO;
import com.jinwang.auth.domain.service.AuthUserDomainService;
import com.jinwang.auth.infra.basic.entity.AuthRole;
import com.jinwang.auth.infra.basic.entity.AuthUser;
import com.jinwang.auth.infra.basic.entity.AuthUserRole;
import com.jinwang.auth.infra.basic.service.AuthRoleService;
import com.jinwang.auth.infra.basic.service.AuthUserRoleService;
import com.jinwang.auth.infra.basic.service.AuthUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class AuthUserDomainServiceImpl implements AuthUserDomainService {

    @Resource
    private AuthUserService authUserService;

    @Resource
    private AuthRoleService authRoleService;

    @Resource
    AuthUserRoleService authUserRoleService;

    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser exitAuthUser = new AuthUser();
        exitAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUsers = authUserService.queryByCondition(exitAuthUser);
        if (!CollectionUtils.isEmpty(existUsers)) {
            return true;
        }
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        authUser.setPassword(SaSecureUtil.md5(authUser.getPassword()));
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
}
