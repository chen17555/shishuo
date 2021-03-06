package com.czh.shishuo.admin.service.impl;

import com.czh.shishuo.admin.dao.QuestionMapper;
import com.czh.shishuo.admin.dao.QuestionReplyMapper;
import com.czh.shishuo.admin.dao.QuestionTagMapper;
import com.czh.shishuo.admin.dao.UserCollectQuestionMapper;
import com.czh.shishuo.admin.dto.QuesetionSaveDto;
import com.czh.shishuo.admin.dto.QuestionReplyDto;
import com.czh.shishuo.admin.service.QuestionService;
import com.czh.shishuo.admin.vo.QuestionReplyVO;
import com.czh.shishuo.admin.vo.QuestionVO;
import com.czh.shishuo.admin.vo.UserVO;
import com.czh.shishuo.enums.ReplyStatusEnum;
import com.czh.shishuo.enums.StatusEnum;
import com.czh.shishuo.utils.ClickNumUtil;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.ResultVO;
import com.czh.shishuo.model.*;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Resource
    QuestionMapper questionMapper;

    @Resource
    QuestionReplyMapper questionReplyMapper;

    @Resource
    QuestionTagMapper questionTagMapper;

    @Resource
    UserCollectQuestionMapper userCollectQuestionMapper;


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
            Question questionSave = new Question();
            questionSave.setQuestionTitle(question.getTitle());
            questionSave.setQuestionContent(question.getContent());
            questionSave.setQuestionStatus(StatusEnum.ACTIVE.getCode());
            questionSave.setCreateTime(new Date());
            questionSave.setUserId(user.getUserId());
            questionSave.setClickNum(0);
            questionMapper.insert(questionSave);

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
        QuestionReply replySave = new QuestionReply();
        replySave.setUserId(user.getUserId());
        replySave.setParentId(reply.getParentId());
        replySave.setRepleyContent(reply.getContent());
        replySave.setQuestionId(reply.getQuestionId());
        replySave.setCreateTime(new Date());
        replySave.setReplyStatus(ReplyStatusEnum.ACTIVE.getCode());
        questionReplyMapper.insertSelective(replySave);
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
