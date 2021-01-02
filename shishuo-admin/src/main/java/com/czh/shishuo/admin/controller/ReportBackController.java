package com.czh.shishuo.admin.controller;

import com.czh.shishuo.admin.dto.ReportDto;
import com.czh.shishuo.admin.service.ReportService;
import com.czh.shishuo.admin.vo.ReportVO;
import com.czh.shishuo.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.czh.shishuo.vo.ResultVO;

import javax.annotation.Resource;

@RestController
@RequestMapping("back/report")
public class ReportBackController {

    @Resource
    ReportService reportService;

    @RequestMapping("/questionlist")
    public PageVO showQuestionReportList(int page, int limit){
        PageInfo<ReportVO> pageinfo = new PageInfo<>(reportService.showQuestionAll(page,limit));
        return PageVO.success(pageinfo.getList(),pageinfo.getTotal());
    }

    @RequestMapping("/replylist")
    public PageVO showReplyReportList(int page,int limit){
        PageInfo<ReportVO> pageinfo = new PageInfo<>(reportService.showReplyAll(page,limit));
        return PageVO.success(pageinfo.getList(),pageinfo.getTotal());
    }

    @RequestMapping("/update")
    public ResultVO updateReport(ReportDto report){
        return reportService.dealReport(report,Integer.valueOf(report.getTypes()));
    }
}
