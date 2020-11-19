package com.chenzhiheng.mapper;

import com.chenzhiheng.model.UserCollectBlog;
import com.chenzhiheng.model.UserCollectBlogKey;

public interface UserCollectBlogMapper {
    int deleteByPrimaryKey(UserCollectBlogKey key);

    int insert(UserCollectBlog record);

    int insertSelective(UserCollectBlog record);

    UserCollectBlog selectByPrimaryKey(UserCollectBlogKey key);

    int updateByPrimaryKeySelective(UserCollectBlog record);

    int updateByPrimaryKey(UserCollectBlog record);
}