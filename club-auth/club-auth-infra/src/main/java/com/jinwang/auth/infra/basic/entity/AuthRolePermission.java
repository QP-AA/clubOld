package com.jinwang.auth.infra.basic.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (AuthRolePermission)实体类
 *
 * @author makejava
 * @since 2024-10-24 11:13:39
 */
public class AuthRolePermission implements Serializable {
    private static final long serialVersionUID = -83111598623285104L;

    private Integer id;

    private Integer roleId;

    private Integer permissionId;

    private Date createdAt;

    private String createdBy;

    private String updatedBy;

    private Date updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}

