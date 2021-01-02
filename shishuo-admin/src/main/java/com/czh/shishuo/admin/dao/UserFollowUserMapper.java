package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.UserFollowUser;
import com.czh.shishuo.model.UserFollowUserKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowUserMapper {
    int deleteByPrimaryKey(UserFollowUserKey key);

    int insert(UserFollowUser record);

    int insertSelective(UserFollowUser record);

    UserFollowUser selectByPrimaryKey(UserFollowUserKey key);

    int updateByPrimaryKeySelective(UserFollowUser record);

    int updateByPrimaryKey(UserFollowUser record);
}