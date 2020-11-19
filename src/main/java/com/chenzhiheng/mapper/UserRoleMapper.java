package com.chenzhiheng.mapper;

import com.chenzhiheng.model.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}