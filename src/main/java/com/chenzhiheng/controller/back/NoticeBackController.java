package com.chenzhiheng.controller.back;

import com.chenzhiheng.model.Notice;
import com.chenzhiheng.service.NoticeService;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.vo.ResultVO;

@RestController
@RequestMapping("back/notice")
public class NoticeBackController {

    @Autowired
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
