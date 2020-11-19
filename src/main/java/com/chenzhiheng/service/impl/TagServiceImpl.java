package com.chenzhiheng.service.impl;

import com.chenzhiheng.mapper.TagMapper;
import com.chenzhiheng.model.Tag;
import com.chenzhiheng.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List<Tag> showAllTag() {
        return tagMapper.selectAllTags();
    }

    @Override
    public List<Tag> getRecommendTag() {
        return tagMapper.selectRecommendTag();
    }

    @Override
    public List<Tag> showUserUnFollowTags(Integer userId) {
        return tagMapper.selectUserUnFollowTags(userId);
    }

    @Override
    public List<Tag> showUserFollowTags(Integer userId) {
        return tagMapper.selectUserFollowTags(userId);
    }

    @Override
    public Tag getTagById(Integer tagId) {
        return tagMapper.selectByPrimaryKey(tagId);
    }


}
