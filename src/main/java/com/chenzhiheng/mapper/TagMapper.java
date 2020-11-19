package com.chenzhiheng.mapper;

import com.chenzhiheng.model.Tag;

import java.util.List;

public interface TagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer tagId);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> selectAllTags();

    List<Tag> selectRecommendTag();

    List<Tag> selectUserUnFollowTags(Integer userId);

    List<Tag> selectUserFollowTags(Integer userId);
}