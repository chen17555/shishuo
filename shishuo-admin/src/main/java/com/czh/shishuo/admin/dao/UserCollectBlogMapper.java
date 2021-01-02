package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.UserCollectBlog;
import com.czh.shishuo.model.UserCollectBlogKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCollectBlogMapper {
    int deleteByPrimaryKey(UserCollectBlogKey key);

    int insert(UserCollectBlog record);

    int insertSelective(UserCollectBlog record);

    UserCollectBlog selectByPrimaryKey(UserCollectBlogKey key);

    int updateByPrimaryKeySelective(UserCollectBlog record);

    int updateByPrimaryKey(UserCollectBlog record);
}