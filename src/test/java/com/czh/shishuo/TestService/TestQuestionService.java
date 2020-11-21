package com.czh.shishuo.TestService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.czh.shishuo.service.QuestionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestQuestionService {

    @Autowired
    QuestionService questionService;

    @Test
    public void testPage(){
        System.out.println(questionService.showQuestionNewPage(1,10).size());
    }
}
