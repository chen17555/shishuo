package com.czh.shishuo.admin.dao;

import com.czh.shishuo.admin.vo.ReportVO;
import com.czh.shishuo.model.Report;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(Report record);

    int insertSelective(Report record);

    Report selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(Report record);

    int updateByPrimaryKey(Report record);

    List<ReportVO> selectAllByType(Integer type);
}