package com.czh.shishuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.czh.shishuo.dto.ReportDto;
import com.czh.shishuo.service.ReportService;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.ResultVO;
import com.czh.shishuo.vo.UserVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class ReportController {

    @Resource
    ReportService reportService;

    @Resource
    HttpServletRequest request;

    @RequestMapping(value = "/report",method =  RequestMethod.POST)
    public ResultVO report(ReportDto report){
        UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
        if(user != null){
            report.setComplainUserId(user.getUserId());
            return reportService.submitReport(report);
        }
        return ResultVOUtil.error(-1,"请登录");
    }
}
