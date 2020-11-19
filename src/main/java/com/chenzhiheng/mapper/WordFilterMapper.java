package com.chenzhiheng.mapper;

import com.chenzhiheng.model.WordFilter;

public interface WordFilterMapper {
    int insert(WordFilter record);

    int insertSelective(WordFilter record);
}