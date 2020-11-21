package com.czh.shishuo.mapper;

import com.czh.shishuo.model.FileSize;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileSizeMapper {
    int insert(FileSize record);

    int insertSelective(FileSize record);
}