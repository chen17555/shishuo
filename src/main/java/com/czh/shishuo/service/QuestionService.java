package com.czh.shishuo.service;

import com.czh.shishuo.model.Question;
import com.czh.shishuo.dto.QuesetionSaveDto;
import com.czh.shishuo.dto.QuestionReplyDto;
import com.czh.shishuo.vo.QuestionReplyVO;
import com.czh.shishuo.vo.QuestionVO;
import com.czh.shishuo.vo.ResultVO;
import com.czh.shishuo.vo.UserVO;

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
