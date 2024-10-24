package com.jinwang.auth.domain.convert;

import com.jinwang.auth.domain.entity.AuthPermissionBO;
import com.jinwang.auth.infra.basic.entity.AuthPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户bo转换器
 *
 * @author: ChickenWing
 * @date: 2023/10/8
 */
@Mapper
public interface AuthPermissionBOConverter {

    AuthPermissionBOConverter INSTANCE = Mappers.getMapper(AuthPermissionBOConverter.class);

    AuthPermission convertBOToEntity(AuthPermissionBO authPermissionBO);

    AuthPermissionBO convertEntityToBO(AuthPermission authPermission);

    List<AuthPermissionBO> convertEntityToBO(List<AuthPermission> authPermissionList);

}
