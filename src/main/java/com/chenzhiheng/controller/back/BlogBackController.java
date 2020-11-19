package com.chenzhiheng.controller.back;

import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.service.BlogService;

@RestController
@RequestMapping("back/blog")
public class BlogBackController {

    @Autowired
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
