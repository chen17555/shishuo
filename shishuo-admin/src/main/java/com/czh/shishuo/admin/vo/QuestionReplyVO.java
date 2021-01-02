package com.czh.shishuo.admin.vo;

import java.util.Date;

public class QuestionReplyVO {

    private Integer qustReplyId;

    private Integer userId;

    private String userNickName;

    private String userAvatar;

    private String repleyContent;

    private Date  repleyTime;

    private Integer replyNum;

    public Integer getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }

    public Integer getQustReplyId() {
        return qustReplyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public String getRepleyContent() {
        return repleyContent;
    }

    public Date getRepleyTime() {
        return repleyTime;
    }

    public void setQustReplyId(Integer qustReplyId) {
        this.qustReplyId = qustReplyId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public void setRepleyContent(String repleyContent) {
        this.repleyContent = repleyContent;
    }

    public void setRepleyTime(Date repleyTime) {
        this.repleyTime = repleyTime;
    }

    @Override
    public String toString() {
        return "QuestionReplyVO{" +
                "qustReplyId=" + qustReplyId +
                ", userId=" + userId +
                ", userNickName='" + userNickName + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", repleyContent='" + repleyContent + '\'' +
                ", repleyTime=" + repleyTime +
                '}';
    }
}
