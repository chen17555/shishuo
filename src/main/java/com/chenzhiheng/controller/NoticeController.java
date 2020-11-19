package com.chenzhiheng.controller;

import com.chenzhiheng.model.Notice;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.chenzhiheng.service.NoticeService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @Autowired
    HttpServletRequest request;

    @GetMapping
    public String index(){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_NAV,SessionBean.SEESION_KEY_OF_NAV_NOTICE);
        return "forward:notice/1";
    }

    @RequestMapping("/{pageNum}")
    public ModelAndView list(@PathVariable("pageNum") int pageNum){
        ModelAndView mv = new ModelAndView();
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeService.showAll(pageNum,10),7);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestURI",request.getRequestURI());
        mv.setViewName("notice");
        return mv;
    }

    @RequestMapping("/detail/{noticeId}")
    public ModelAndView detail(@PathVariable("noticeId") int noticeId){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("notice_detail");
        Notice notice = noticeService.showNoticeById(noticeId);
        mv.addObject("notice",notice);
        return mv;
    }
}
