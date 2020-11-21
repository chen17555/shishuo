package com.czh.shishuo.TestMapper;

import com.czh.shishuo.enums.StatusEnum;
import com.czh.shishuo.mapper.KeymanMapper;
import com.czh.shishuo.mapper.QuestionMapper;
import com.czh.shishuo.mapper.QuestionTagMapper;
import com.czh.shishuo.model.Question;
import com.czh.shishuo.model.QuestionTagKey;
import com.czh.shishuo.service.QuestionService;
import com.czh.shishuo.utils.RandDataUtil;
import com.czh.shishuo.vo.QuestionVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuestionMapper {

    @Resource
    QuestionMapper questionMapper;

    @Resource
    QuestionTagMapper questionTagMapper;

    @Resource
    KeymanMapper keymanMapper;

    @Resource
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
