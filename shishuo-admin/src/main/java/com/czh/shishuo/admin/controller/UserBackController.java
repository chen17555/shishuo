package com.czh.shishuo.admin.controller;

import com.czh.shishuo.admin.service.UserService;
import com.czh.shishuo.admin.vo.UserVO;
import com.czh.shishuo.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("back/user")
public class UserBackController {

    @Resource
    UserService userService;

    @RequestMapping("/list")
    public PageVO list(Integer page, Integer limit){
        PageInfo<UserVO> pageInfo = new PageInfo<>(userService.selectAll(page,limit));
        return  PageVO.success(pageInfo.getList(),pageInfo.getTotal());
    }
}
