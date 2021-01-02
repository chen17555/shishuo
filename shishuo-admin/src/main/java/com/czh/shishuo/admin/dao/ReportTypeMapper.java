package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.ReportType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportTypeMapper {
    int deleteByPrimaryKey(Integer reportTypeId);

    int insert(ReportType record);

    int insertSelective(ReportType record);

    ReportType selectByPrimaryKey(Integer reportTypeId);

    int updateByPrimaryKeySelective(ReportType record);

    int updateByPrimaryKey(ReportType record);

    List<ReportType> selectAll();
}