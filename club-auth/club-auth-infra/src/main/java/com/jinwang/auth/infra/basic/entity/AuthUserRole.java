package com.jinwang.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthUserRole)实体类
 *
 * @author makejava
 * @since 2024-10-23 19:29:58
 */
@Data
public class AuthUserRole implements Serializable {
    private static final long serialVersionUID = -63938609777686918L;

    private Integer id;

    private Long userId;

    private Long roleId;

    private Date createdAt;

    private String createdBy;

    private String updatedBy;

    private Date updatedAt;

}

