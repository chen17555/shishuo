package com.chenzhiheng.service.impl;

import com.chenzhiheng.mapper.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenzhiheng.dto.UserLoginDto;
import xin.sysout.mapper.*;
import com.chenzhiheng.model.Tag;
import com.chenzhiheng.model.UserFollowTag;
import com.chenzhiheng.model.UserFollowUser;
import com.chenzhiheng.model.UserInfo;
import com.chenzhiheng.service.UserService;
import com.chenzhiheng.utils.ResultVOUtil;
import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    UserInfoMapper userInfoMapper;

    @Autowired
    UserFollowTagMapper userFollowTagMapper;

    @Autowired
    UserFollowUserMapper userFollowUserMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
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
