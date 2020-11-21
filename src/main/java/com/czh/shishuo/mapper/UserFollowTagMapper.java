package com.czh.shishuo.mapper;

import com.czh.shishuo.model.UserFollowTag;
import com.czh.shishuo.model.UserFollowTagKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserFollowTagMapper {
    int deleteByPrimaryKey(UserFollowTagKey key);

    int insert(UserFollowTag record);

    int insertSelective(UserFollowTag record);

    UserFollowTag selectByPrimaryKey(UserFollowTagKey key);

    int updateByPrimaryKeySelective(UserFollowTag record);

    int updateByPrimaryKey(UserFollowTag record);
}