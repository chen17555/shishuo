package com.chenzhiheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.dto.ReportDto;
import com.chenzhiheng.service.ReportService;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ReportController {

    @Autowired
    ReportService reportService;

    @Autowired
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
