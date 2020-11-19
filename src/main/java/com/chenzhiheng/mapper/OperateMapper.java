package com.chenzhiheng.mapper;

import com.chenzhiheng.model.Operate;

public interface OperateMapper {
    int deleteByPrimaryKey(Integer operateId);

    int insert(Operate record);

    int insertSelective(Operate record);

    Operate selectByPrimaryKey(Integer operateId);

    int updateByPrimaryKeySelective(Operate record);

    int updateByPrimaryKey(Operate record);
}