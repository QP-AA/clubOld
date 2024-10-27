package com.jinwang.auth.domain.service;


import cn.dev33.satoken.stp.SaTokenInfo;
import com.jinwang.auth.domain.entity.AuthUserBO;

import java.util.List;

/**
 * 用户领域service
 *
 * @author: jinwang
 * @date: 2023/11/1
 */
public interface AuthUserDomainService {

    /**
     * 注册
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * 修改
     */
    Boolean update(AuthUserBO authUserBO);

    /**
     * 删除
     */
    Boolean delete(AuthUserBO authUserBO);

    /**
     * 登录
     * @param validCode
     * @return
     */
    SaTokenInfo doLogin(String validCode);
}

