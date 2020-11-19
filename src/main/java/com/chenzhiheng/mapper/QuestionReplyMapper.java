package com.chenzhiheng.mapper;

import com.chenzhiheng.model.QuestionReply;
import com.chenzhiheng.vo.QuestionReplyVO;

import java.util.List;

public interface QuestionReplyMapper {
    int deleteByPrimaryKey(Integer qustReplyId);

    int insert(QuestionReply record);

    int insertSelective(QuestionReply record);

    QuestionReply selectByPrimaryKey(Integer qustReplyId);

    int updateByPrimaryKeySelective(QuestionReply record);

    int updateByPrimaryKey(QuestionReply record);

    List<QuestionReplyVO> selectByQuestionId(int questionId);

    List<QuestionReplyVO> selectQuestionReplyByParentId(int parentId);
}