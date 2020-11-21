package com.czh.shishuo.service.impl;

import com.czh.shishuo.mapper.TagMapper;
import com.czh.shishuo.model.Tag;
import com.czh.shishuo.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Resource
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
