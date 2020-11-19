package com.chenzhiheng.model;

import java.util.Date;

public class QuestionReply {
    private Integer qustReplyId;

    private Integer userId;

    private Integer parentId;

    private String repleyContent;

    private Date createTime;

    private Integer replyStatus;

    private Integer questionId;

    public Integer getQustReplyId() {
        return qustReplyId;
    }

    public void setQustReplyId(Integer qustReplyId) {
        this.qustReplyId = qustReplyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRepleyContent() {
        return repleyContent;
    }

    public void setRepleyContent(String repleyContent) {
        this.repleyContent = repleyContent == null ? null : repleyContent.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }
}