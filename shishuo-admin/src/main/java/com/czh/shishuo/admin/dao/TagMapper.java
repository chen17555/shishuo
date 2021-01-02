package com.czh.shishuo.admin.dao;

import com.czh.shishuo.model.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
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