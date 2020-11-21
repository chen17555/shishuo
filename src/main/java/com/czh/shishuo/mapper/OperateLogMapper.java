package com.czh.shishuo.mapper;

import com.czh.shishuo.model.OperateLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
    int insert(OperateLog record);

    int insertSelective(OperateLog record);
}