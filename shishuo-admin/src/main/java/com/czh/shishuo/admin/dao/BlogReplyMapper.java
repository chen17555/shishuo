package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.BlogReply;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogReplyMapper {
    int deleteByPrimaryKey(Integer blogReplyId);

    int insert(BlogReply record);

    int insertSelective(BlogReply record);

    BlogReply selectByPrimaryKey(Integer blogReplyId);

    int updateByPrimaryKeySelective(BlogReply record);

    int updateByPrimaryKey(BlogReply record);
}