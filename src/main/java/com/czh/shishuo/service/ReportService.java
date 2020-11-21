package com.czh.shishuo.service;

import com.czh.shishuo.model.ReportType;
import com.czh.shishuo.vo.ReportVO;
import com.czh.shishuo.dto.ReportDto;
import com.czh.shishuo.vo.ResultVO;

import java.util.List;

public interface ReportService {

    List<ReportType> showAll();

    List<ReportVO> showQuestionAll(int pageNum, int pageSize);

    List<ReportVO> showReplyAll(int pageNum,int pageSize);

    ResultVO dealReport(ReportDto report,int type);

    ResultVO submitReport(ReportDto report);
}
