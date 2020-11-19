package com.chenzhiheng.mapper;

import com.chenzhiheng.model.ReportType;

import java.util.List;

public interface ReportTypeMapper {
    int deleteByPrimaryKey(Integer reportTypeId);

    int insert(ReportType record);

    int insertSelective(ReportType record);

    ReportType selectByPrimaryKey(Integer reportTypeId);

    int updateByPrimaryKeySelective(ReportType record);

    int updateByPrimaryKey(ReportType record);

    List<ReportType> selectAll();
}