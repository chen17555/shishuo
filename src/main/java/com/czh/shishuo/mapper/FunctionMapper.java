package com.czh.shishuo.mapper;

import com.czh.shishuo.model.Function;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FunctionMapper {
    int deleteByPrimaryKey(Integer functionId);

    int insert(Function record);

    int insertSelective(Function record);

    Function selectByPrimaryKey(Integer functionId);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}