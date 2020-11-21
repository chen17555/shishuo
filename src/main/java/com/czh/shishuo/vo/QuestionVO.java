package com.czh.shishuo.vo;


import java.util.List;

public class QuestionVO {
    private Integer questionId;

    private Integer authorId;

    private String authorName;

    private String authorAvatar;

    private String questionTitle;

    private String questionContent;

    private Integer clickNum;

    private Integer answerNum;

    private String questionTags;

    private String questionTagImg;

    private String postTime;

    private List<QuestionReplyVO> replyList;

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getQuestionTagImg() {
        return questionTagImg;
    }

    public void setQuestionTagImg(String questionTagImg) {
        this.questionTagImg = questionTagImg;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public String getQuestionTags() {
        return questionTags;
    }

    public List<QuestionReplyVO> getReplyList() {
        return replyList;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public void setQuestionTags(String questionTags) {
        this.questionTags = questionTags;
    }

    public void setReplyList(List<QuestionReplyVO> replyList) {
        this.replyList = replyList;
    }

    @Override
    public String toString() {
        return "QuestionVO{" +
                "questionId=" + questionId +
                ", authorId='" + authorId + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorAvatar='" + authorAvatar + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", clickNum=" + clickNum +
                ", answerNum=" + answerNum +
                ", questionTags='" + questionTags + '\'' +
                ", replyList=" + replyList +
                '}';
    }
}
