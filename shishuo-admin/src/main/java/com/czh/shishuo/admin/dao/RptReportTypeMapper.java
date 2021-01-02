package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.RptReportTypeKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RptReportTypeMapper {
    int deleteByPrimaryKey(RptReportTypeKey key);

    int insert(RptReportTypeKey record);

    int insertSelective(RptReportTypeKey record);
}