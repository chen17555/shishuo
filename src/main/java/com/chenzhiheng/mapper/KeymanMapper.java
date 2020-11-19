package com.chenzhiheng.mapper;

import com.chenzhiheng.model.Keyman;

public interface KeymanMapper {
    int insert(Keyman record);

    int insertSelective(Keyman record);

    Integer selectPrimaryKeyByTableName(String tbName);

    int updatePrimaryKeyByTableName(Keyman record);
}