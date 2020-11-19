package com.chenzhiheng.mapper;

import com.chenzhiheng.model.RoleFunction;
import com.chenzhiheng.model.RoleFunctionKey;

public interface RoleFunctionMapper {
    int deleteByPrimaryKey(RoleFunctionKey key);

    int insert(RoleFunction record);

    int insertSelective(RoleFunction record);

    RoleFunction selectByPrimaryKey(RoleFunctionKey key);

    int updateByPrimaryKeySelective(RoleFunction record);

    int updateByPrimaryKey(RoleFunction record);
}