package com.chenzhiheng.controller.back;

import com.chenzhiheng.model.Question;
import com.chenzhiheng.service.QuestionService;
import com.chenzhiheng.vo.PageVO;
import com.chenzhiheng.vo.QuestionVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chenzhiheng.enums.StatusEnum;
import com.chenzhiheng.vo.ResultVO;

@RestController
@RequestMapping("back/question")
public class QuestionBackController {

    @Autowired
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
