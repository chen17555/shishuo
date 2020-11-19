package com.chenzhiheng.service;

import com.chenzhiheng.model.ReportType;
import com.chenzhiheng.vo.ReportVO;
import com.chenzhiheng.dto.ReportDto;
import com.chenzhiheng.vo.ResultVO;

import java.util.List;

public interface ReportService {

    List<ReportType> showAll();

    List<ReportVO> showQuestionAll(int pageNum, int pageSize);

    List<ReportVO> showReplyAll(int pageNum,int pageSize);

    ResultVO dealReport(ReportDto report,int type);

    ResultVO submitReport(ReportDto report);
}
