package com.czh.shishuo.admin.service.impl;

import com.czh.shishuo.admin.dao.TagMapper;
import com.czh.shishuo.admin.service.TagService;
import com.czh.shishuo.model.Tag;
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
