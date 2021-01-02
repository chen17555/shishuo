package com.czh.shishuo.admin.controller;

import com.czh.shishuo.admin.service.NoticeService;
import com.czh.shishuo.model.Notice;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.czh.shishuo.vo.ResultVO;

import javax.annotation.Resource;

@RestController
@RequestMapping("notice")
public class NoticeBackController {

    @Resource
    NoticeService noticeService;

    @RequestMapping("/list")
    public PageVO list(Integer page, Integer limit){
        PageInfo<Notice> list = new PageInfo<>(noticeService.showAll(page,limit));;
        return PageVO.success(list.getList(),list.getTotal());
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResultVO save(String title,String content){
        noticeService.saveNotice(1000,title,content);
        return ResultVOUtil.success();
    }

}
