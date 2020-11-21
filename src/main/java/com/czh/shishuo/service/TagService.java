package com.czh.shishuo.service;


import com.czh.shishuo.model.Tag;

import java.util.List;

public interface TagService {
    List<Tag> showAllTag();

    List<Tag> getRecommendTag();

    List<Tag> showUserUnFollowTags(Integer userId);

    List<Tag> showUserFollowTags(Integer userId);

    Tag getTagById(Integer tagId);
}
