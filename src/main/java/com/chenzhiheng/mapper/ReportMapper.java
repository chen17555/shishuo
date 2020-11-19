package com.chenzhiheng.mapper;

import com.chenzhiheng.model.Report;
import com.chenzhiheng.vo.ReportVO;

import java.util.List;

public interface ReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    List<ReportVO> selectAllByType(Integer type);
}