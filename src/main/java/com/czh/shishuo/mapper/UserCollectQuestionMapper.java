package com.czh.shishuo.mapper;

import com.czh.shishuo.model.UserCollectQuestion;
import com.czh.shishuo.model.UserCollectQuestionKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCollectQuestionMapper {
    int deleteByPrimaryKey(UserCollectQuestionKey key);

    int insert(UserCollectQuestion record);

    int insertSelective(UserCollectQuestion record);

    UserCollectQuestion selectByPrimaryKey(UserCollectQuestionKey key);

    int updateByPrimaryKeySelective(UserCollectQuestion record);

    int updateByPrimaryKey(UserCollectQuestion record);
}