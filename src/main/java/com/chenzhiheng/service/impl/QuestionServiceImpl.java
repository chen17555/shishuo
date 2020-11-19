package com.chenzhiheng.service.impl;

import com.chenzhiheng.dto.QuesetionSaveDto;
import com.chenzhiheng.dto.QuestionReplyDto;
import com.chenzhiheng.enums.ReplyStatusEnum;
import com.chenzhiheng.enums.StatusEnum;
import com.chenzhiheng.mapper.*;
import com.chenzhiheng.model.*;
import com.chenzhiheng.service.QuestionService;
import com.chenzhiheng.utils.ClickNumUtil;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.QuestionReplyVO;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.sysout.mapper.*;
import xin.sysout.model.*;

import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    QuestionReplyMapper questionReplyMapper;

    @Autowired
    QuestionTagMapper questionTagMapper;

    @Autowired
    UserCollectQuestionMapper userCollectQuestionMapper;

    @Autowired
    KeymanMapper keymanMapper;


    @Override
    public List<QuestionVO> showQuestionNewPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return  questionMapper.selectNewPage();
    }

    @Override
    public List<QuestionVO> showQuestionRecommendPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return questionMapper.selectRecommendPage();
    }

    @Override
    public List<QuestionVO> showQuestionNewPage(int tagId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return questionMapper.selectNewDataByTag(tagId);
    }

    @Override
    public List<QuestionVO> showQuestionRecommendPage(int tagId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return questionMapper.selectRecommendDataByTag(tagId);
    }

    @Override
    public List<QuestionVO> showQuestionList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return questionMapper.selectQuestionList();
    }

    @Override
    public List<QuestionVO> showQuestionRecoveryList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return questionMapper.selectQuestionRecoveryList();
    }

    @Override
    public QuestionVO showQuestionDetail(int questionId,int pageNum, int pageSize) {
        QuestionVO questionVO = questionMapper.selectQuestionVoByQuestionId(questionId);
        if(questionVO != null){
            questionVO.setReplyList(questionReplyMapper.selectByQuestionId(questionId));
        }
        return questionVO;
    }

    @Override
    public ResultVO updateQuestion(Question question) {
        question.setUpdateTime(new Date());
        questionMapper.updateByPrimaryKeySelective(question);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO saveQuestion(QuesetionSaveDto question, UserVO user) {
        try{
            Integer primaryKey = keymanMapper.selectPrimaryKeyByTableName("question");
            Question questionSave = new Question();
            questionSave.setQuestionId(primaryKey);
            questionSave.setQuestionTitle(question.getTitle());
            questionSave.setQuestionContent(question.getContent());
            questionSave.setQuestionStatus(StatusEnum.ACTIVE.getCode());
            questionSave.setCreateTime(new Date());
            questionSave.setUserId(user.getUserId());
            questionSave.setClickNum(0);
            questionMapper.insert(questionSave);
            keymanMapper.updatePrimaryKeyByTableName(new Keyman("question"));

            String[] tags = question.getTags().split(",");
            for(int i = 0;i < tags.length;i++){
                QuestionTagKey tag = new QuestionTagKey();
                tag.setTagId(Integer.valueOf(tags[i]));
                tag.setQuestionId(questionSave.getQuestionId());
                questionTagMapper.insert(tag);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
            return ResultVOUtil.error(-1,e.getMessage());
        }
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO saveReply(QuestionReplyDto reply, UserVO user) {
        Integer primaryKey = keymanMapper.selectPrimaryKeyByTableName("question_reply");
        QuestionReply replySave = new QuestionReply();
        replySave.setQustReplyId(primaryKey);
        replySave.setUserId(user.getUserId());
        replySave.setParentId(reply.getParentId());
        replySave.setRepleyContent(reply.getContent());
        replySave.setQuestionId(reply.getQuestionId());
        replySave.setCreateTime(new Date());
        replySave.setReplyStatus(ReplyStatusEnum.ACTIVE.getCode());
        questionReplyMapper.insertSelective(replySave);
        keymanMapper.updatePrimaryKeyByTableName(new Keyman("question_reply"));
        return ResultVOUtil.success();
    }


    @Override
    public int updataQuestionClick(int questionId, int clickNum) {
        clickNum = ClickNumUtil.getLuckClick();
        return  questionMapper.updataQuestionClickByQuestionId(questionId,clickNum);
    }

    @Override
    public ResultVO collectQuestion(int questionId, UserVO user) {
        UserCollectQuestion collect = new UserCollectQuestion();
        collect.setUserId(user.getUserId());
        collect.setQuestionId(questionId);
        collect.setCareteTime(new Date());
        userCollectQuestionMapper.insert(collect);
        return ResultVOUtil.success();
    }

    @Override
    public List<QuestionReplyVO> getQuestionReplyByReplyId(int replyId){
        PageHelper.startPage(0,10);
        List<QuestionReplyVO> replyList = questionReplyMapper.selectQuestionReplyByParentId(replyId);
        return replyList;
    }


    private List<QuestionReplyVO> getQuestionReplyPage(int questionId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionReplyVO> replyVOList = questionReplyMapper.selectByQuestionId(questionId);
        return replyVOList;
    }


}
