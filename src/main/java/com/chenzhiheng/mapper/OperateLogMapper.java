package com.chenzhiheng.mapper;

import com.chenzhiheng.model.OperateLog;

public interface OperateLogMapper {
    int insert(OperateLog record);

    int insertSelective(OperateLog record);
}