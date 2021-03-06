package com.czh.shishuo.admin.controller;

import com.czh.shishuo.admin.service.BlogService;
import com.czh.shishuo.admin.vo.BlogVO;
import com.czh.shishuo.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("blog")
public class BlogBackController {

    @Resource
    BlogService blogService;

    @RequestMapping("/list")
    public PageVO list(Integer page, Integer limit){
        PageInfo<BlogVO> blog = new PageInfo<>(blogService.showBlogNewData(page,limit));
        return PageVO.success(blog.getList(),blog.getTotal());
    }

    @RequestMapping("/recovery")
    public PageVO blogRecoveryList(Integer page, Integer limit){
        PageInfo<BlogVO> blog = new PageInfo<>(blogService.showBlogNewData(page,limit));
        return PageVO.success(blog.getList(),blog.getTotal());
    }
}
