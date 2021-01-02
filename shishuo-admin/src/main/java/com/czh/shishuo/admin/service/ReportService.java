package com.czh.shishuo.admin.service;

import com.czh.shishuo.admin.dto.ReportDto;
import com.czh.shishuo.admin.vo.ReportVO;
import com.czh.shishuo.model.ReportType;
import com.czh.shishuo.vo.ResultVO;

import java.util.List;

public interface ReportService {

    List<ReportType> showAll();

    List<ReportVO> showQuestionAll(int pageNum, int pageSize);

    List<ReportVO> showReplyAll(int pageNum, int pageSize);

    ResultVO dealReport(ReportDto report, int type);

    ResultVO submitReport(ReportDto report);
}
