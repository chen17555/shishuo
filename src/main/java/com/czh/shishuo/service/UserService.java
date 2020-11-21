package com.czh.shishuo.service;

import com.czh.shishuo.model.Tag;
import com.czh.shishuo.vo.BlogVO;
import com.czh.shishuo.dto.UserLoginDto;
import com.czh.shishuo.vo.QuestionVO;
import com.czh.shishuo.vo.ResultVO;
import com.czh.shishuo.vo.UserVO;

import java.util.List;


public interface UserService {

    UserVO login(UserLoginDto user);

    UserVO searchUserByUserId(Integer userId);

    UserVO register(UserVO user);

    ResultVO userFollowUsers(UserVO user,UserVO followed);

    ResultVO userFollowTags(UserVO user, Tag tag);

    List<UserVO> selectAll(Integer page, Integer limit);

    List<QuestionVO> showQuestionListBySort(int pageNum, int pageSize, String sort, UserVO user);

    List<BlogVO> showBlogListBySort(int pageNum, int pageSize, String sort, UserVO user);
}
