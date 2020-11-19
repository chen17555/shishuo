package com.chenzhiheng.controller;

import com.chenzhiheng.model.Tag;
import com.chenzhiheng.utils.ResultVOUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.chenzhiheng.dto.BlogSaveDto;
import com.chenzhiheng.service.BlogService;
import com.chenzhiheng.service.TagService;
import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@RequestMapping("blog")
public class BlogController {


    @Autowired
    BlogService blogService;

    @Autowired
    TagService tagService;

    @Autowired
    HttpServletRequest request;


    @GetMapping
    public String blogIndex(){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_NAV,SessionBean.SEESION_KEY_OF_NAV_BLOG);
        return "forward:blog/recommend/1";
    }

    @RequestMapping(value = "/recommend/{pageNum}")
    public ModelAndView getRecommendBlogList(@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_BLOG_PAGE,"recommend");
        List<BlogVO> blogList = blogService.showBlogRecommendData(pageNum,10);
        PageInfo<BlogVO> pageInfo = new PageInfo<>(blogList,7);

        ModelAndView mv = new ModelAndView("blog/list");
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestURI",request.getRequestURI());
        return mv;
    }

    @RequestMapping(value = "/new/{pageNum}")
    public ModelAndView getNewBlogList(@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_BLOG_PAGE,"new");
        List<BlogVO> blogList = blogService.showBlogNewData(pageNum,10);
        PageInfo<BlogVO> pageInfo = new PageInfo<>(blogList,7);

        ModelAndView mv = new ModelAndView("blog/list");
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public ModelAndView savePage(){
        List<Tag> tags = tagService.showAllTag();
        ModelAndView mv = new ModelAndView();
        mv.addObject("tags",tags);
        mv.setViewName("blog/save");
        return mv;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseBody
    public ResultVO saveBlog(BlogSaveDto blog){
        UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
        if(user != null){
            return blogService.saveBlog(blog,user);
        }
        return ResultVOUtil.error(-1,"请登录");

    }

    @GetMapping("/detail/{blogId}")
    public ModelAndView detailPage(@PathVariable("blogId") int blogId){
        blogService.updateBlogClick(blogId,1);
        ModelAndView mv = new ModelAndView("blog/detail");
        mv.addObject("blog",blogService.showBlogDetail(blogId));
        return mv;
    }
}
