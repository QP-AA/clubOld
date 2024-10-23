package com.jinwang.auth.domain.convert;

import com.jinwang.auth.domain.entity.AuthRoleBO;
import com.jinwang.auth.infra.basic.entity.AuthRole;
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
public interface AuthRoleBOConverter {

    AuthRoleBOConverter INSTANCE = Mappers.getMapper(AuthRoleBOConverter.class);

    AuthRole convertBOToEntity(AuthRoleBO authRoleBO);

    AuthRoleBO convertEntityToBO(AuthRole authRole);

    List<AuthRoleBO> convertEntityToBO(List<AuthRole> authRoleList);

}
