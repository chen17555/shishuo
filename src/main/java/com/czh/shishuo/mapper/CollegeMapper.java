package com.czh.shishuo.mapper;

import com.czh.shishuo.model.College;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer collegeId);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer collegeId);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}