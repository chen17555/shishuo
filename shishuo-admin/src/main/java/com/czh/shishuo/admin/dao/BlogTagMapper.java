package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.BlogTagKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogTagMapper {
    int deleteByPrimaryKey(BlogTagKey key);

    int insert(BlogTagKey record);

    int insertSelective(BlogTagKey record);
}