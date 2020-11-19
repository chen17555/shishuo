package com.chenzhiheng.mapper;

import com.chenzhiheng.model.FileSize;

public interface FileSizeMapper {
    int insert(FileSize record);

    int insertSelective(FileSize record);
}