package com.czh.shishuo.TestMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.czh.shishuo.enums.ReplyStatusEnum;
import com.czh.shishuo.mapper.QuestionReplyMapper;
import com.czh.shishuo.model.QuestionReply;
import com.czh.shishuo.utils.RandDataUtil;
import com.czh.shishuo.vo.QuestionReplyVO;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuestionReplyMapper {

    @Autowired
    QuestionReplyMapper questionReplyMapper;

    @Test
    public void testInsertData(){
        for(int i = 0; i < 1000;i++){
            QuestionReply questionReply = new QuestionReply();
            questionReply.setQustReplyId(1000 + i);
            questionReply.setUserId(RandDataUtil.getNum(1000,1999));
            questionReply.setRepleyContent(RandDataUtil.getEnglishName(20,50));
            questionReply.setQuestionId(RandDataUtil.getNum(1000,1100));
            questionReply.setReplyStatus(ReplyStatusEnum.ACTIVE.getCode());
            questionReply.setCreateTime(new Date());
            questionReplyMapper.insert(questionReply);
        }
    }

    @Test
    public void testSelectRelply(){
        List<QuestionReplyVO> list  = questionReplyMapper.selectByQuestionId(1002);
        System.out.println(list.size());
    }
}
