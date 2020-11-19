package com.chenzhiheng.mapper;

import com.chenzhiheng.model.CollegeReportKey;

public interface CollegeReportMapper {
    int deleteByPrimaryKey(CollegeReportKey key);

    int insert(CollegeReportKey record);

    int insertSelective(CollegeReportKey record);
}