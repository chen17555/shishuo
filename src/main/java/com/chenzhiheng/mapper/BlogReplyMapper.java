package com.chenzhiheng.mapper;

import com.chenzhiheng.model.BlogReply;

public interface BlogReplyMapper {
    int deleteByPrimaryKey(Integer blogReplyId);

    int insert(BlogReply record);

    int insertSelective(BlogReply record);

    BlogReply selectByPrimaryKey(Integer blogReplyId);

    int updateByPrimaryKeySelective(BlogReply record);

    int updateByPrimaryKey(BlogReply record);
}