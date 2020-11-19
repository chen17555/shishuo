package com.chenzhiheng.mapper;

import com.chenzhiheng.model.CollegeTag;
import com.chenzhiheng.model.CollegeTagKey;

public interface CollegeTagMapper {
    int deleteByPrimaryKey(CollegeTagKey key);

    int insert(CollegeTag record);

    int insertSelective(CollegeTag record);

    CollegeTag selectByPrimaryKey(CollegeTagKey key);

    int updateByPrimaryKeySelective(CollegeTag record);

    int updateByPrimaryKey(CollegeTag record);
}