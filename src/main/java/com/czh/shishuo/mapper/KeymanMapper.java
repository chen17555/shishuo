package com.czh.shishuo.mapper;

import com.czh.shishuo.model.Keyman;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KeymanMapper {
    int insert(Keyman record);

    int insertSelective(Keyman record);

    Integer selectPrimaryKeyByTableName(String tbName);

    int updatePrimaryKeyByTableName(Keyman record);
}