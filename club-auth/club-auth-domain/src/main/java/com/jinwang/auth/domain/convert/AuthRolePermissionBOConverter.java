package com.jinwang.auth.domain.convert;

import com.jinwang.auth.domain.entity.AuthRolePermissionBO;
import com.jinwang.auth.infra.basic.entity.AuthRolePermission;
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
public interface AuthRolePermissionBOConverter {

    AuthRolePermissionBOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionBOConverter.class);

    AuthRolePermission convertBOToEntity(AuthRolePermissionBO AuthRolePermissionBO);

    AuthRolePermissionBO convertEntityToBO(AuthRolePermission AuthRolePermission);

    List<AuthRolePermissionBO> convertEntityToBO(List<AuthRolePermission> AuthRolePermissionList);

}
