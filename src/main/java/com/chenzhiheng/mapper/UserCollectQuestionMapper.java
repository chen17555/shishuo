package com.chenzhiheng.mapper;

import com.chenzhiheng.model.UserCollectQuestion;
import com.chenzhiheng.model.UserCollectQuestionKey;

public interface UserCollectQuestionMapper {
    int deleteByPrimaryKey(UserCollectQuestionKey key);

    int insert(UserCollectQuestion record);

    int insertSelective(UserCollectQuestion record);

    UserCollectQuestion selectByPrimaryKey(UserCollectQuestionKey key);

    int updateByPrimaryKeySelective(UserCollectQuestion record);

    int updateByPrimaryKey(UserCollectQuestion record);
}