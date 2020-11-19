package com.chenzhiheng.mapper;

import com.chenzhiheng.model.QuestionTagKey;

public interface QuestionTagMapper {
    int deleteByPrimaryKey(QuestionTagKey key);

    int insert(QuestionTagKey record);

    int insertSelective(QuestionTagKey record);
}