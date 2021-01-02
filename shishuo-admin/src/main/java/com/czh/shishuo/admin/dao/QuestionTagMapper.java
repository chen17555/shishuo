package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.QuestionTagKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionTagMapper {
    int deleteByPrimaryKey(QuestionTagKey key);

    int insert(QuestionTagKey record);

    int insertSelective(QuestionTagKey record);
}