package com.chenzhiheng.controller.back;

import com.chenzhiheng.service.UserService;
import com.chenzhiheng.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.vo.UserVO;

@RestController
@RequestMapping("back/user")
public class UserBackController {

    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public PageVO list(Integer page, Integer limit){
        PageInfo<UserVO> pageInfo = new PageInfo<>(userService.selectAll(page,limit));
        return  PageVO.success(pageInfo.getList(),pageInfo.getTotal());
    }
}
