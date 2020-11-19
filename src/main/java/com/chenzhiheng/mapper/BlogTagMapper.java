package com.chenzhiheng.mapper;

import com.chenzhiheng.model.BlogTagKey;

public interface BlogTagMapper {
    int deleteByPrimaryKey(BlogTagKey key);

    int insert(BlogTagKey record);

    int insertSelective(BlogTagKey record);
}