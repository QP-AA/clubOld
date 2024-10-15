use club;
CREATE TABLE auth_user (
                           id INT AUTO_INCREMENT PRIMARY KEY,               -- 用户ID，自增
                           user_name VARCHAR(50) NOT NULL,                  -- 用户名
                           nick_name VARCHAR(50),                           -- 昵称
                           email VARCHAR(100),                              -- 邮箱
                           phone VARCHAR(20),                               -- 电话
                           password VARCHAR(255) NOT NULL,                  -- 密码（加密后的）
                           sex CHAR(1),                                     -- 性别 (M: 男, F: 女)
                           avatar VARCHAR(255),                             -- 头像URL
                           status TINYINT DEFAULT 1,                        -- 状态 (1: 启用, 0: 禁用)
                           created_user VARCHAR(50),                        -- 创建用户
                           create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- 创建时间
                           update_user VARCHAR(50),                         -- 更新用户
                           update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, -- 更新时间
                           introduce TEXT,                                  -- 用户介绍
                           ext_json JSON                                    -- 扩展字段（JSON格式）
);

CREATE TABLE auth_role (
                           id INT PRIMARY KEY AUTO_INCREMENT,         -- 角色的唯一标识，自动递增
                           role_name VARCHAR(50) NOT NULL,            -- 角色名称
                           status TINYINT(1) DEFAULT 1,               -- 角色状态（1: 启用，0: 禁用）
                           role_key VARCHAR(50) NOT NULL,             -- 角色标识/键，用于权限控制
                           created_by VARCHAR(50),                    -- 创建人用户名或 ID
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 创建时间，默认为当前时间
                           updated_by VARCHAR(50),                    -- 修改人用户名或 ID
                           updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改时间，修改时自动更新
);

CREATE TABLE auth_user_role (
                                id INT PRIMARY KEY AUTO_INCREMENT,         -- 角色的唯一标识，自动递增
                                user_id INT NOT NULL,                     -- 用户ID，关联用户表的主键
                                role_id INT NOT NULL,                     -- 角色ID，关联角色表的主键
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 记录分配角色的时间
                                created_by VARCHAR(50),                   -- 记录是谁分配的角色
                                updated_by VARCHAR(50),                    -- 修改人用户名或 ID
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP -- 修改时间，修改时自动更新
);
