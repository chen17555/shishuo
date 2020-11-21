package com.czh.shishuo.mapper;

import com.czh.shishuo.model.CollegeReportKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeReportMapper {
    int deleteByPrimaryKey(CollegeReportKey key);

    int insert(CollegeReportKey record);

    int insertSelective(CollegeReportKey record);
}