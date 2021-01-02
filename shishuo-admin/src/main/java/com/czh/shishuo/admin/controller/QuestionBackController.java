package com.czh.shishuo.admin.controller;

import com.czh.shishuo.admin.service.QuestionService;
import com.czh.shishuo.admin.vo.QuestionVO;
import com.czh.shishuo.model.Question;
import com.czh.shishuo.vo.PageVO;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.czh.shishuo.enums.StatusEnum;
import com.czh.shishuo.vo.ResultVO;

import javax.annotation.Resource;

@RestController
@RequestMapping("back/question")
public class QuestionBackController {

    @Resource
    QuestionService questionService;

    @RequestMapping("/list")
    public PageVO questionList(Integer page, Integer limit){
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionService.showQuestionList(page,limit));
        return PageVO.success(pageInfo.getList(),pageInfo.getTotal());
    }

    @RequestMapping("/recovery")
    public PageVO questionRecoveryList(Integer page, Integer limit){
        PageInfo<QuestionVO> pageInfo = new PageInfo<>(questionService.showQuestionRecoveryList(page,limit));
        return PageVO.success(pageInfo.getList(),pageInfo.getTotal());
    }

    @RequestMapping("/delete")
    public ResultVO deleteQuestion(Integer questionId){
        Question question = new Question();
        question.setQuestionId(questionId);
        question.setQuestionStatus(StatusEnum.DELETE.getCode());
        return questionService.updateQuestion(question);
    }

    @RequestMapping("/update")
    public ResultVO updateQuestion(Integer questionId){
        Question question = new Question();
        question.setQuestionId(questionId);
        question.setQuestionStatus(StatusEnum.ACTIVE.getCode());
        return questionService.updateQuestion(question);
    }
}
