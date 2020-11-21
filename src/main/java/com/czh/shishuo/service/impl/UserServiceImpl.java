package com.czh.shishuo.service.impl;

import com.czh.shishuo.mapper.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.czh.shishuo.dto.UserLoginDto;
import com.czh.shishuo.model.Tag;
import com.czh.shishuo.model.UserFollowTag;
import com.czh.shishuo.model.UserFollowUser;
import com.czh.shishuo.model.UserInfo;
import com.czh.shishuo.service.UserService;
import com.czh.shishuo.utils.ResultVOUtil;
import com.czh.shishuo.vo.BlogVO;
import com.czh.shishuo.vo.QuestionVO;
import com.czh.shishuo.vo.ResultVO;
import com.czh.shishuo.vo.UserVO;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    TagMapper tagMapper;

    @Resource
    UserInfoMapper userInfoMapper;

    @Resource
    UserFollowTagMapper userFollowTagMapper;

    @Resource
    UserFollowUserMapper userFollowUserMapper;

    @Resource
    QuestionMapper questionMapper;

    @Resource
    BlogMapper blogMapper;

    @Override
    public UserVO login(UserLoginDto user) {
        Integer userId = userMapper.selectByUserNameAndPassword(user.getUserName(),user.getUserPwd());
        if(userId != null){
            UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
            UserVO vo = new UserVO();
            BeanUtils.copyProperties(userInfo,vo);
            return vo;
        }
        return null;
    }

    @Override
    public UserVO searchUserByUserId(Integer userId) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(userInfo,vo);
        return vo;
    }

    @Override
    public UserVO register(UserVO user) {
        return null;
    }

    @Override
    public ResultVO userFollowUsers(UserVO user, UserVO followed) {
        UserFollowUser userFollowUser = new UserFollowUser();
        userFollowUser.setUserId(user.getUserId());
        userFollowUser.setUserFollowedId(followed.getUserId());
        userFollowUser.setCreateTime(new Date());
        userFollowUserMapper.insert(userFollowUser);
        return ResultVOUtil.success();
    }

    @Override
    public ResultVO userFollowTags(UserVO user, Tag tag) {
        UserFollowTag userFollowTag = new UserFollowTag();
        userFollowTag.setUserId(user.getUserId());
        userFollowTag.setTagId(tag.getTagId());
        userFollowTag.setCreateTime(new Date());
        userFollowTagMapper.insert(userFollowTag);
        return ResultVOUtil.success();
    }

    @Override
    public List<UserVO> selectAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return userMapper.selectAll();
    }

    @Override
    public List<QuestionVO> showQuestionListBySort(int pageNum, int pageSize, String sort, UserVO user) {
        PageHelper.startPage(pageNum,pageSize);
        List<QuestionVO> list = null;
        switch (sort){
            case "": list= questionMapper.selectQuestionListByUserId(user.getUserId()); break;
            case "reply":list = questionMapper.selectQuestionListByReplyUserId(user.getUserId()); break;
            case "floowr":list = questionMapper.selectQuestionListByUserCollect(user.getUserId());break;
        }
        return list;
    }

    @Override
    public List<BlogVO> showBlogListBySort(int pageNum, int pageSize, String sort, UserVO user) {
        PageHelper.startPage(pageNum,pageSize);
        List<BlogVO> list = null;
        switch (sort){
            case "": list= blogMapper.selectQuestionListByUserId(user.getUserId()); break;
            case "reply":list = blogMapper.selectQuestionListByReplyUserId(user.getUserId()); break;
            case "floowr":list = blogMapper.selectQuestionListByUserCollect(user.getUserId());break;
        }
        return list;
    }

}
