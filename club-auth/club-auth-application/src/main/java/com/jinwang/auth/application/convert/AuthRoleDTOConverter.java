package com.jinwang.auth.application.convert;

import com.jinwang.auth.domain.entity.AuthRoleBO;
import com.jinwang.auth.application.dto.AuthRoleDTO;
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
public interface AuthRoleDTOConverter {

    AuthRoleDTOConverter INSTANCE = Mappers.getMapper(AuthRoleDTOConverter.class);

    AuthRoleBO convertDTOToBO(AuthRoleDTO authRoleDTO);

    AuthRoleDTO convertBOToDTO(AuthRoleBO authRoleBO);

    List<AuthRoleDTO> convertBOToDTO(List<AuthRoleBO> authRoleBO);

}
