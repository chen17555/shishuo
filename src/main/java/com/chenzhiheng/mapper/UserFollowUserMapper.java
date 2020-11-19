package com.chenzhiheng.mapper;

import com.chenzhiheng.model.UserFollowUser;
import com.chenzhiheng.model.UserFollowUserKey;

public interface UserFollowUserMapper {
    int deleteByPrimaryKey(UserFollowUserKey key);

    int insert(UserFollowUser record);

    int insertSelective(UserFollowUser record);

    UserFollowUser selectByPrimaryKey(UserFollowUserKey key);

    int updateByPrimaryKeySelective(UserFollowUser record);

    int updateByPrimaryKey(UserFollowUser record);
}