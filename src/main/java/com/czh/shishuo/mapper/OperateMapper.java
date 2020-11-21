package com.czh.shishuo.mapper;

import com.czh.shishuo.model.Operate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateMapper {
    int deleteByPrimaryKey(Integer operateId);

    int insert(Operate record);

    int insertSelective(Operate record);

    Operate selectByPrimaryKey(Integer operateId);

    int updateByPrimaryKeySelective(Operate record);

    int updateByPrimaryKey(Operate record);
}