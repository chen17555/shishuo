package com.chenzhiheng.controller.back;

import com.chenzhiheng.service.ReportService;
import com.chenzhiheng.vo.PageVO;
import com.chenzhiheng.vo.ReportVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.dto.ReportDto;
import com.chenzhiheng.vo.ResultVO;

@RestController
@RequestMapping("back/report")
public class ReportBackController {

    @Autowired
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
