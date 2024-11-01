package com.jinwang.auth.application.convert;

import com.jinwang.auth.application.dto.AuthPermissionDTO;
import com.jinwang.auth.domain.entity.AuthPermissionBO;
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
public interface AuthPermissionDTOConverter {

    AuthPermissionDTOConverter INSTANCE = Mappers.getMapper(AuthPermissionDTOConverter.class);

    AuthPermissionBO convertDTOToBO(AuthPermissionDTO authPermissionDTO);

    AuthPermissionDTO convertBOToDTO(AuthPermissionBO authPermissionBO);

    List<AuthPermissionDTO> convertBOToDTO(List<AuthPermissionBO> authPermissionBO);

}
