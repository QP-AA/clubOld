package com.jinwang.auth.domain.service.impl;

import com.jinwang.auth.domain.convert.AuthUserBOConverter;
import com.jinwang.auth.domain.entity.AuthUserBO;
import com.jinwang.auth.domain.service.AuthUserDomainService;
import com.jinwang.auth.infra.basic.entity.AuthUser;
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
    @Override
    public Boolean register(AuthUserBO authUserBO) {
        AuthUser exitAuthUser = new AuthUser();
        exitAuthUser.setUserName(authUserBO.getUserName());
        List<AuthUser> existUsers = authUserService.queryByCondition(exitAuthUser);
        if (!CollectionUtils.isEmpty(existUsers)) {
            return true;
        }
        AuthUser authUser = AuthUserBOConverter.INSTANCE.convertBOToEntity(authUserBO);
        log.info("开始注册到数据库");
        Integer cnt = authUserService.insert(authUser);
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
