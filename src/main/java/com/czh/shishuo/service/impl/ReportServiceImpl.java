package com.czh.shishuo.service.impl;


import com.czh.shishuo.service.ReportService;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.ReportVO;
import com.czh.shishuo.mapper.*;
import com.czh.shishuo.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import com.czh.shishuo.dto.ReportDto;
import com.czh.shishuo.enums.StatusEnum;
import com.czh.shishuo.vo.ResultVO;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    ReportMapper reportMapper;

    @Resource
    ReportTypeMapper reportTypeMapper;

    @Resource
    RptReportTypeMapper rptReportTypeMapper;

    @Resource
    QuestionMapper questionMapper;

    @Resource
    QuestionReplyMapper questionReplyMapper;

    @Resource
    KeymanMapper keymanMapper;

    public ResultVO submitReport(ReportDto report){
        Integer key = keymanMapper.selectPrimaryKeyByTableName("report");
        report.setReportId(key);
        report.setReportStatus(StatusEnum.DELETE.getCode());
        report.setCreateTime(new Date());
        report.setUpdateTime(new Date());
        reportMapper.insertSelective(report);

        String[] reportType = report.getTypes().split(",");
        for(int i = 0;i < reportType.length;i++){
            RptReportTypeKey reportTypeKey = new RptReportTypeKey();
            reportTypeKey.setReportId(key);
            reportTypeKey.setReportTypeId(Integer.valueOf(reportType[i]));
            rptReportTypeMapper.insert(reportTypeKey);
        }

        keymanMapper.updatePrimaryKeyByTableName(new Keyman("report"));
        return ResultVOUtil.success();
    }

    @Override
    public List<ReportType> showAll() {
        return reportTypeMapper.selectAll();
    }

    @Override
    public List<ReportVO> showQuestionAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return reportMapper.selectAllByType(1);
    }

    @Override
    public List<ReportVO> showReplyAll(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return reportMapper.selectAllByType(2);
    }

    @Override
    public ResultVO dealReport(ReportDto report,int type) {
        if(type == 2){
            if(report.getReportedType() == 1){
                Question question = new Question();
                question.setQuestionId(report.getReportedId());
                question.setQuestionStatus(StatusEnum.DELETE.getCode());
                question.setUpdateTime(new Date());
                questionMapper.updateByPrimaryKeySelective(question);
            }else if(report.getReportedType() == 2){
                QuestionReply reply = new QuestionReply();
                reply.setQustReplyId(report.getReportedReplyId());
                reply.setReplyStatus(StatusEnum.DELETE.getCode());
                questionReplyMapper.updateByPrimaryKeySelective(reply);
            }
        }
        Report report1 = new Report();
        report1.setReportId(report.getReportId());
        report1.setUpdateTime(new Date());
        report1.setReportStatus(StatusEnum.ACTIVE.getCode());
        reportMapper.updateByPrimaryKeySelective(report1);
        return ResultVOUtil.success();
    }

}
