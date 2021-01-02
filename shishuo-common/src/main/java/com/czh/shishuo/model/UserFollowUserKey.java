package com.czh.shishuo.model;

public class UserFollowUserKey {
    private Integer userId;

    private Integer userFollowedId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserFollowedId() {
        return userFollowedId;
    }

    public void setUserFollowedId(Integer userFollowedId) {
        this.userFollowedId = userFollowedId;
    }
}