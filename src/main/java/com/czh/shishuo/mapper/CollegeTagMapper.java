package com.czh.shishuo.mapper;

import com.czh.shishuo.model.CollegeTag;
import com.czh.shishuo.model.CollegeTagKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeTagMapper {
    int deleteByPrimaryKey(CollegeTagKey key);

    int insert(CollegeTag record);

    int insertSelective(CollegeTag record);

    CollegeTag selectByPrimaryKey(CollegeTagKey key);

    int updateByPrimaryKeySelective(CollegeTag record);

    int updateByPrimaryKey(CollegeTag record);
}