package com.jinwang.auth.application.convert;

import com.jinwang.auth.application.dto.AuthRolePermissionDTO;
import com.jinwang.auth.domain.entity.AuthRolePermissionBO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 用户dto转换器
 *
 * @author: ChickenWing
 * @date: 2023/10/8
 */
@Mapper
public interface AuthRolePermissionDTOConverter {

    AuthRolePermissionDTOConverter INSTANCE = Mappers.getMapper(AuthRolePermissionDTOConverter.class);

    AuthRolePermissionBO convertDTOToBO(AuthRolePermissionDTO AuthRolePermissionDTO);

    AuthRolePermissionDTO convertBOToDTO(AuthRolePermissionBO AuthRolePermissionBO);

    List<AuthRolePermissionDTO> convertBOToDTO(List<AuthRolePermissionBO> AuthRolePermissionBO);

}
