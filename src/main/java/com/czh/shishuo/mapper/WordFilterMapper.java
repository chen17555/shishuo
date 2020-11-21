package com.czh.shishuo.mapper;

import com.czh.shishuo.model.WordFilter;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WordFilterMapper {
    int insert(WordFilter record);

    int insertSelective(WordFilter record);
}