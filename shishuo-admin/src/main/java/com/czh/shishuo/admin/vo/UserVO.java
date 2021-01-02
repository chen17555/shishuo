package com.czh.shishuo.admin.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserVO {

    private Integer userId;

    private Integer userAge;

    private Boolean userSex;

    private String userEmail;

    private String userPhone;

    private String userNickname;

    private String userDesc;

    private String userAvatar;

    private Integer followNum;

    private Integer followerNum;

    private Date createTime;

    private String role;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public Boolean getUserSex() {
        return userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public Integer getFollowerNum() {
        return followerNum;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserSex(Boolean userSex) {
        this.userSex = userSex;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public void setFollowerNum(Integer followerNum) {
        this.followerNum = followerNum;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "userId=" + userId +
                ", userAge=" + userAge +
                ", userSex=" + userSex +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userNickname='" + userNickname + '\'' +
                ", userDesc='" + userDesc + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", followNum=" + followNum +
                ", followerNum=" + followerNum +
                '}';
    }
}
