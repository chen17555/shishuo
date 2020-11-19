package com.chenzhiheng.TestMapper;

import com.chenzhiheng.enums.StatusEnum;
import com.chenzhiheng.mapper.KeymanMapper;
import com.chenzhiheng.mapper.QuestionMapper;
import com.chenzhiheng.mapper.QuestionTagMapper;
import com.chenzhiheng.model.Question;
import com.chenzhiheng.model.QuestionTagKey;
import com.chenzhiheng.service.QuestionService;
import com.chenzhiheng.utils.RandDataUtil;
import com.chenzhiheng.vo.QuestionVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuestionMapper {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionTagMapper questionTagMapper;

    @Autowired
    KeymanMapper keymanMapper;

    @Autowired
    QuestionService questionService;

    @Test
    public void testInsert(){
        for(int i = 0;i < 100;i++){
            Question question = new Question();
            question.setQuestionId(1001 + i);
            question.setUserId(RandDataUtil.getNum(1000,1999));
            question.setQuestionTitle(RandDataUtil.getEnglishName(15,30));
            question.setQuestionContent(RandDataUtil.getEnglishName(50,100));
            question.setClickNum(0);
            question.setQuestionStatus(StatusEnum.ACTIVE.getCode());
            question.setCreateTime(new Date());
            questionMapper.insert(question);
            Integer tagId = RandDataUtil.getNum(100,139);
            for(int j = 0;j <= i % 2;j++){
                QuestionTagKey questionTagKey = new QuestionTagKey();
                questionTagKey.setQuestionId(question.getQuestionId());
                Integer tagIb = RandDataUtil.getNum(100,139);
                if(tagIb != tagId){
                    tagId = tagIb;
                    questionTagKey.setTagId(tagId);
                    questionTagMapper.insert(questionTagKey);
                }
            }
        }
    }
    @Test
    public void  testInsertData(){
        String[] title = {};
        Question question = new Question();
        question.setQuestionId(1000);
        question.setUserId(1000);
        question.setQuestionTitle("Test");
        question.setQuestionContent("TestTestTestTestTestTestTestTestTestTestTestTestTestTest");
        question.setClickNum(0);
        question.setQuestionStatus(StatusEnum.ACTIVE.getCode());
        question.setCreateTime(new Date());
    }

    @Test
    public void testSelectPage(){
        List<QuestionVO> list = questionService.showQuestionNewPage(1,10);
        System.out.println(list.size());
    }

    @Test
    public void testSelectQuestionVO(){
        QuestionVO vo  = questionMapper.selectQuestionVoByQuestionId(1002);
        System.out.println(vo);
    }

}
