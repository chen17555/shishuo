package com.czh.shishuo.admin.dao;

import com.czh.shishuo.admin.vo.QuestionReplyVO;
import com.czh.shishuo.model.QuestionReply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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