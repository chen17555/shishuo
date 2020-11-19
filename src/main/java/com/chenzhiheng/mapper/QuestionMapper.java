package com.chenzhiheng.mapper;

import com.chenzhiheng.model.Question;
import org.apache.ibatis.annotations.Param;
import com.chenzhiheng.vo.QuestionVO;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    List<QuestionVO> selectNewPage();

    List<QuestionVO> selectRecommendPage();

    List<QuestionVO> selectNewDataByTag(int tagId);

    List<QuestionVO> selectRecommendDataByTag(int tagId);

    List<QuestionVO> selectQuestionList();

    List<QuestionVO> selectQuestionRecoveryList();

    List<QuestionVO> selectQuestionListByUserId(int userId);

    List<QuestionVO> selectQuestionListByReplyUserId(int userId);

    List<QuestionVO> selectQuestionListByUserCollect(int userId);

    QuestionVO selectQuestionVoByQuestionId(Integer questionId);

    int updataQuestionClickByQuestionId(@Param("questionId") Integer questionId,@Param("clickNum") Integer clickNum);
}