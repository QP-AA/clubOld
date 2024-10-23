package com.jinwang.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2024-10-23 10:19:51
 */
@Data
public class AuthRole implements Serializable {
    private static final long serialVersionUID = 141301720755710089L;

    private Long id;

    private String roleName;

    private Integer status;

    private String roleKey;

    private String createdBy;

    private Date createdAt;

    private String updatedBy;

    private Date updatedAt;
}

