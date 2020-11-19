package com.chenzhiheng.controller;

import com.chenzhiheng.model.Tag;
import com.chenzhiheng.utils.ResultVOUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.chenzhiheng.dto.QuesetionSaveDto;
import com.chenzhiheng.dto.QuestionReplyDto;
import com.chenzhiheng.service.QuestionService;
import com.chenzhiheng.service.ReportService;
import com.chenzhiheng.service.TagService;
import com.chenzhiheng.vo.QuestionReplyVO;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("wenda")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    HttpServletRequest request;

    @Autowired
    TagService tagService;

    @Autowired
    ReportService reportService;

    //一页所显示的内容数目
    private final  Integer PAGESIZE = 10;

    //分页导航数目
    private final Integer NAVIGATE_PAGES = 7;

    private final Integer CLICK_NUM = 1;


    @RequestMapping(method = RequestMethod.GET)
    public String questionIndex(){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_NAV,SessionBean.SEESION_KEY_OF_NAV_QUESTION);
        return "forward:wenda/recommend/1";
    }

    @RequestMapping(value = "/recommend/{pageNum}")
    public ModelAndView getRecommendQuestionList(@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_QUESTION_PAGE,SessionBean.SEESION_KEY_OF_RECOMMEND_PAGE);
        List<QuestionVO> questionList = questionService.showQuestionRecommendPage(pageNum,PAGESIZE);
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionList,NAVIGATE_PAGES);
        ModelAndView mv = getModelAndView(request);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("requestURI",request.getRequestURI());
        return mv;
    }

    @RequestMapping(value = "/new/{pageNum}")
    public ModelAndView getNewQuestionList(@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_QUESTION_PAGE,SessionBean.SEESION_KEY_OF_NEW_PAGE);
        List<QuestionVO> questionList = questionService.showQuestionNewPage(pageNum,PAGESIZE);
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionList,NAVIGATE_PAGES);
        ModelAndView mv = getModelAndView(request);
        mv.addObject("pageInfo",pageInfo);
        return mv;
    }


    @RequestMapping(value = "/tag/{tagId}")
    public String getTagQuestion(@PathVariable("tagId")int tagId){
        return "forward:/wenda/tag/"+tagId+"/recommend/1";
    }


    @RequestMapping(value = "/tag/{tagId}/recommend/{pageNum}")
    public ModelAndView getTagRecommendQuestionList(@PathVariable("tagId")int tagId,@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_QUESTION_PAGE,SessionBean.SEESION_KEY_OF_RECOMMEND_PAGE);
        //标签信息
        Tag tagInfo = tagService.getTagById(tagId);
        //标签包含的问答列表
        List<QuestionVO> questionList = questionService.showQuestionRecommendPage(tagId,pageNum,PAGESIZE);
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionList,NAVIGATE_PAGES);

        ModelAndView mv = getModelAndView(request);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("tagInfo",tagInfo);
        mv.setViewName("question/tag");
        return mv;
    }

    @RequestMapping(value = "/tag/{tagId}/new/{pageNum}")
    public ModelAndView getTagNewQuestionList(@PathVariable("tagId")int tagId,@PathVariable("pageNum")int pageNum){
        request.getSession().setAttribute(SessionBean.SEESION_KEY_OF_QUESTION_PAGE,SessionBean.SEESION_KEY_OF_NEW_PAGE);
        //标签信息
        Tag tagInfo = tagService.getTagById(tagId);
        //标签包含的问答列表
        List<QuestionVO> questionList = questionService.showQuestionNewPage(tagId,pageNum,PAGESIZE);
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionList,NAVIGATE_PAGES);

        ModelAndView mv = getModelAndView(request);
        mv.addObject("pageInfo",pageInfo);
        mv.addObject("tagInfo",tagInfo);
        mv.setViewName("question/tag");
        return mv;
    }

    private ModelAndView getModelAndView(HttpServletRequest request){
        List<Tag> recommendTags = null;
        ModelAndView mv = new ModelAndView();
        if(request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER) == null){
            recommendTags = tagService.getRecommendTag();
        }else{
            UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
            recommendTags = tagService.showUserUnFollowTags(user.getUserId());
            mv.addObject("userTags",tagService.showUserFollowTags(user.getUserId()));
        }
        mv.addObject("recommendTags",recommendTags);
        mv.setViewName("question/list");
        return mv;
    }

    @RequestMapping(value = "/detail/{questionId}")
    public ModelAndView getQuestionInfo(@PathVariable("questionId")int questionId, @RequestParam(value="page", defaultValue="1")int page){
        questionService.updataQuestionClick(questionId, CLICK_NUM);
        QuestionVO questionVO = questionService.showQuestionDetail(questionId,page,PAGESIZE);
        ModelAndView mv = new ModelAndView();
        mv.addObject("question",questionVO);
        mv.addObject("reportType",reportService.showAll());
        mv.setViewName("question/detail");
        return mv;
    }

    @RequestMapping(value = "/save")
    public ModelAndView savePage(){
        List<Tag> tags = tagService.showAllTag();
        ModelAndView mv = new ModelAndView();
        mv.addObject("tags",tags);
        mv.setViewName("question/save");
        return mv;
    }

    @RequestMapping(value = "/savequestion")
    @ResponseBody
    public ResultVO saveQuestion(QuesetionSaveDto question,HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
        if(user != null){
            return questionService.saveQuestion(question,user);
        }
        return ResultVOUtil.error(-1,"请登录");
    }

    @RequestMapping(value = "/getreplys")
    @ResponseBody
    public ResultVO<QuestionReplyVO> getQuestionReply(Integer replyId){
        return ResultVOUtil.success(questionService.getQuestionReplyByReplyId(replyId));
    }

    @RequestMapping(value = "/savesuccess")
    public ModelAndView saveSuccess(){
        return new ModelAndView("question/savesuccess");
    }

    @RequestMapping(value = "/savereply")
    @ResponseBody
    public ResultVO saveReply(QuestionReplyDto reply,HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute(SessionBean.SESSION_KEY_OF_USER);
        if(user != null){
            return questionService.saveReply(reply,user);
        }
        return ResultVOUtil.error(-1,"请登录");
    }

    @RequestMapping(value = "/collect")
    @ResponseBody
    public ResultVO  collect(@PathVariable("questionId")int questionId){

        return ResultVOUtil.success();
    }
}
