package com.chenzhiheng.mapper;

import com.chenzhiheng.model.UserFollowTag;
import com.chenzhiheng.model.UserFollowTagKey;

public interface UserFollowTagMapper {
    int deleteByPrimaryKey(UserFollowTagKey key);

    int insert(UserFollowTag record);

    int insertSelective(UserFollowTag record);

    UserFollowTag selectByPrimaryKey(UserFollowTagKey key);

    int updateByPrimaryKeySelective(UserFollowTag record);

    int updateByPrimaryKey(UserFollowTag record);
}