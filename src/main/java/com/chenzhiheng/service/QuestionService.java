package com.chenzhiheng.service;

import com.chenzhiheng.model.Question;
import com.chenzhiheng.dto.QuesetionSaveDto;
import com.chenzhiheng.dto.QuestionReplyDto;
import com.chenzhiheng.vo.QuestionReplyVO;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import java.util.List;

public interface QuestionService {

    List<QuestionVO> showQuestionNewPage(int pageNum, int pageSize);

    List<QuestionVO> showQuestionRecommendPage(int pageNum, int pageSize);

    List<QuestionVO> showQuestionNewPage(int tagId,int pageNum, int pageSize);

    List<QuestionVO> showQuestionRecommendPage(int tagId,int pageNum, int pageSize);

    List<QuestionVO> showQuestionList(int pageNum, int pageSize);

    List<QuestionVO> showQuestionRecoveryList(int pageNum, int pageSize);

    QuestionVO showQuestionDetail(int questionId, int pageNum, int pageSize);

    ResultVO updateQuestion(Question question);

    ResultVO saveQuestion(QuesetionSaveDto question, UserVO user);

    ResultVO saveReply(QuestionReplyDto reply, UserVO user);

    int updataQuestionClick(int questionId, int clickNum);

    ResultVO collectQuestion(int questionId, UserVO user);

    List<QuestionReplyVO> getQuestionReplyByReplyId(int replyId);
}
