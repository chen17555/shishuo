package com.chenzhiheng.service;

import com.chenzhiheng.model.Tag;
import com.chenzhiheng.vo.BlogVO;
import com.chenzhiheng.dto.UserLoginDto;
import com.chenzhiheng.vo.QuestionVO;
import com.chenzhiheng.vo.ResultVO;
import com.chenzhiheng.vo.UserVO;

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
