package com.czh.shishuo.mapper;

import com.czh.shishuo.model.RoleFunction;
import com.czh.shishuo.model.RoleFunctionKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleFunctionMapper {
    int deleteByPrimaryKey(RoleFunctionKey key);

    int insert(RoleFunction record);

    int insertSelective(RoleFunction record);

    RoleFunction selectByPrimaryKey(RoleFunctionKey key);

    int updateByPrimaryKeySelective(RoleFunction record);

    int updateByPrimaryKey(RoleFunction record);
}