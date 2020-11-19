package com.chenzhiheng.mapper;

import com.chenzhiheng.model.RptReportTypeKey;

public interface RptReportTypeMapper {
    int deleteByPrimaryKey(RptReportTypeKey key);

    int insert(RptReportTypeKey record);

    int insertSelective(RptReportTypeKey record);
}